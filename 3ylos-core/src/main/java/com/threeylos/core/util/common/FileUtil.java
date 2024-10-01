package com.threeylos.core.util.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.util.Properties;

/**
 * 
 * 
 * General file manipulation utilities.
 * <p>
 * Facilities are provided in the following areas:
 * <ul>
 * <li>writing to a file
 * <li>reading from a file
 * <li>make a directory including parent directories
 * <li>copying files and directories
 * <li>deleting files and directories
 * <li>converting to and from a URL
 * <li>listing files and directories by filter and extension
 * <li>comparing file content
 * <li>file last changed date
 * <li>calculating a checksum
 * </ul>
 * <p>
 * 
 * 
 * <p>
 * Note that a specific charset should be specified whenever possible. Relying
 * on the platform default means that the code is Locale-dependent. Only use the
 * default if the files are known to always use the platform default.
 * <p>
 * 
 * @author AbhinitKumar
 *
 */

public final class FileUtil {

	private static final Logger logger = LogManager.getLogger(FileUtil.class);

	private FileUtil() {

	}

	/**
	 * Property file loaded from resource folder
	 * 
	 * @return Properties
	 */
	public static Properties getProperties(String fileName) {

		Properties prop = null;
		try {
			if (fileName == null) {
				throw new NullPointerException("File name must not be null");
			}
			InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null) {
				throw new NullPointerException("File path is wrong");
			}
			prop = new Properties();
			prop.load(inputStream);
		} catch (IOException e) {
			logger.error("Error is getting property file name: {} reading", fileName, e);
		}
		return prop;

	}

	public static String getGlobalTestProperties(String filePath, String key) {
		try {
			Properties prop = new Properties();
			InputStream fis = FileUtil.class.getClassLoader().getResourceAsStream(filePath);
			prop.load(fis);
			return prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;

	}

	/**
	 * Construct a file from the set of name elements.
	 *
	 * @param directory the parent directory
	 * @param names     the name elements
	 * @return the file
	 */
	public static File getFile(final File directory, final String... names) {
		return FileUtils.getFile(directory, names);
	}

	/**
	 * Construct a file from the set of name elements.
	 *
	 * @param names the name elements
	 * @return the file
	 */
	public static File getFile(final String... names) {
		return FileUtils.getFile(names);
	}

	/**
	 * Convert from a <code>URL</code> to a <code>File</code>.
	 * <p>
	 * From version 1.1 this method will decode the URL. Syntax such as
	 * <code>file:///my%20docs/file.txt</code> will be correctly decoded to
	 * <code>/my docs/file.txt</code>. Starting with version 1.5, this method uses
	 * UTF-8 to decode percent-encoded octets to characters. Additionally, malformed
	 * percent-encoded octets are handled leniently by passing them through
	 * literally.
	 *
	 * @return the equivalent <code>File</code> object, or {@code null} if the URL's
	 *         protocol is not <code>file</code>
	 */
	public static File getFile(final URL uri) {
		return FileUtils.toFile(uri);

	}

	/**
	 * Opens a {@link FileInputStream} for the specified file, providing better
	 * error messages than simply calling <code>new FileInputStream(file)</code>.
	 * <p>
	 * At the end of the method either the stream will be successfully opened, or an
	 * exception will have been thrown.
	 * <p>
	 * An exception is thrown if the file does not exist. An exception is thrown if
	 * the file object exists but is a directory. An exception is thrown if the file
	 * exists but cannot be read.
	 *
	 * @param file the file to open for input, must not be {@code null}
	 * @return a new {@link FileInputStream} for the specified file
	 * @throws FileNotFoundException if the file does not exist
	 * @throws IOException           if the file object is a directory
	 * @throws IOException           if the file cannot be read
	 */
	public static FileInputStream openInputStream(final File file) throws IOException {
		return FileUtils.openInputStream(file);
	}

	/**
	 * Opens a {@link FileOutputStream} for the specified file, checking and
	 * creating the parent directory if it does not exist.
	 * <p>
	 * At the end of the method either the stream will be successfully opened, or an
	 * exception will have been thrown.
	 * <p>
	 * The parent directory will be created if it does not exist. The file will be
	 * created if it does not exist. An exception is thrown if the file object
	 * exists but is a directory. An exception is thrown if the file exists but
	 * cannot be written to. An exception is thrown if the parent directory cannot
	 * be created.
	 *
	 * @param file the file to open for output, must not be {@code null}
	 * @return a new {@link FileOutputStream} for the specified file
	 * @throws IOException if the file object is a directory
	 * @throws IOException if the file cannot be written to
	 * @throws IOException if a parent directory needs creating but that fails
	 */
	public static FileOutputStream openOutputStream(final File file) throws IOException {
		return FileUtils.openOutputStream(file);
	}

	/**
	 * Opens a {@link FileOutputStream} for the specified file, checking and
	 * creating the parent directory if it does not exist.
	 * <p>
	 * At the end of the method either the stream will be successfully opened, or an
	 * exception will have been thrown.
	 * <p>
	 * The parent directory will be created if it does not exist. The file will be
	 * created if it does not exist. An exception is thrown if the file object
	 * exists but is a directory. An exception is thrown if the file exists but
	 * cannot be written to. An exception is thrown if the parent directory cannot
	 * be created.
	 *
	 * @param file   the file to open for output, must not be {@code null}
	 * @param append if {@code true}, then bytes will be added to the end of the
	 *               file rather than overwriting
	 * @return a new {@link FileOutputStream} for the specified file
	 * @throws IOException if the file object is a directory
	 * @throws IOException if the file cannot be written to
	 * @throws IOException if a parent directory needs creating but that fails
	 */
	public static FileOutputStream openOutputStream(final File file, final boolean append) throws IOException {
		return FileUtils.openOutputStream(file, append);
	}

	/**
	 * Gets the system property indicated by the specified key.
	 * First, if there is a security manager, its {@code checkPropertyAccess} method
	 * is called with the key as its argument. This may result in a
	 * SecurityException.
	 * <p>
	 * If there is no current set of system properties, a set of system properties
	 * is first created and initialized in the same manner as for the
	 * {@code getProperties} method.
	 *
	 * @apiNote <strong>Changing a standard system property may have unpredictable
	 *          results unless otherwise specified</strong>. See
	 *          {@linkplain #getProperties getProperties} for details.
	 *
	 * @return the string value of the system property, or {@code null} if there is
	 *         no property with that key.
	 *
	 * @throws SecurityException        if a security manager exists and its
	 *                                  {@code checkPropertyAccess} method doesn't
	 *                                  allow access to the specified system
	 *                                  property.
	 * @throws NullPointerException     if {@code key} is {@code null}.
	 * @throws IllegalArgumentException if {@code key} is empty.
	 * @see java.lang.SecurityException
	 * @see java.lang.System#getProperties()
	 */
	public static String getTempDirectoryPath() {
		return System.getProperty("java.io.tmpdir");
	}

	/**
	 * Creates a new <code>File</code> instance by converting the given pathname
	 * string into an abstract pathname. If the given string is the empty string,
	 * then the result is the empty abstract pathname.
	 *
	 * @throws NullPointerException If the <code>pathname</code> argument is
	 *                              <code>null</code>
	 */
	public static File getTempDirectory() {
		return new File(getTempDirectoryPath());
	}

	/**
	 * Gets the system property indicated by the specified key.
	 * First, if there is a security manager, its {@code checkPropertyAccess} method
	 * is called with the key as its argument. This may result in a
	 * SecurityException.
	 * <p>
	 * If there is no current set of system properties, a set of system properties
	 * is first created and initialized in the same manner as for the
	 * {@code getProperties} method.
	 *
	 * @apiNote <strong>Changing a standard system property may have unpredictable
	 *          results unless otherwise specified</strong>. See
	 *          {@linkplain #getProperties getProperties} for details.
	 *
	 * @return the string value of the system property, or {@code null} if there is
	 *         no property with that key.
	 *
	 * @throws SecurityException        if a security manager exists and its
	 *                                  {@code checkPropertyAccess} method doesn't
	 *                                  allow access to the specified system
	 *                                  property.
	 * @throws NullPointerException     if {@code key} is {@code null}.
	 * @throws IllegalArgumentException if {@code key} is empty.
	 * @see java.lang.SecurityException
	 * @see java.lang.System#getProperties()
	 */
	public static String getUserDirectoryPath() {
		return System.getProperty("user.homework");
	}

	/**
	 * Creates a new <code>File</code> instance by converting the given pathname
	 * string into an abstract pathname. If the given string is the empty string,
	 * then the result is the empty abstract pathname.
	 *
	 * @throws NullPointerException If the <code>pathname</code> argument is
	 *                              <code>null</code>
	 */
	public static File getUserDirectory() {
		return new File(getUserDirectoryPath());
	}

	/**
	 * Gets the extension of a filename.
	 * <p>
	 * This method returns the textual part of the filename after the last dot.
	 * There must be no directory separator after the dot.
	 * 
	 * <pre>
	 * foo.txt      --&gt; "txt"
	 * a/b/c.jpg    --&gt; "jpg"
	 * a/b.txt/c    --&gt; ""
	 * a/b/c        --&gt; ""
	 * </pre>
	 * <p>
	 * The output will be the same irrespective of the machine that the code is
	 * running on.
	 *
	 * @param filename the filename to retrieve the extension of.
	 * @return the extension of the file or an empty string if none exists or
	 *         {@code null} if the filename is {@code null}.
	 */
	public static String getExtension(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	/**
	 * Opens a file for reading, returning a {@code BufferedReader} to read text
	 * from the file in an efficient manner. Bytes from the file are decoded into
	 * characters using the {@link StandardCharsets#UTF_8 UTF-8} {@link Charset
	 * charset}.
	 *
	 * <p>
	 * This method works as if invoking it were equivalent to evaluating the
	 * expression:
	 * 
	 * <pre>
	 * {@code
	 * Files.newBufferedReader(path, StandardCharsets.UTF_8)
	 * }
	 * </pre>
	 *
	 *
	 * @return a new buffered reader, with default buffer size, to read text from
	 *         the file
	 *
	 * @throws IOException       if an I/O error occurs opening the file
	 *
	 */
	public static Reader getReader(String filePath) throws IOException {
		if (filePath == null) {
			throw new NullPointerException("FilePath must not be null");
		}
		return Files.newBufferedReader(getPath(filePath));
	}

	/**
	 * Converts a path string, or a sequence of strings that when joined form a path
	 * string, to a {@code Path}.
	 *
	 * @implSpec This method simply invokes {@link Path#of(String,String...)
	 *           Path.of(String, String...)} with the given parameters.
	 *
	 *
	 * @return the resulting {@code Path}
	 *
	 * @throws InvalidPathException if the path string cannot be converted to a
	 *                              {@code Path}
	 *
	 * @see FileSystem#getPath
	 * @see Path#of(String,String...)
	 */
	public static Path getPath(String filePath) {
		return Paths.get(filePath);
	}

	/**
	 * Opens or creates a file for writing, returning a {@code BufferedWriter} to
	 * write text to the file in an efficient manner. The text is encoded into bytes
	 * for writing using the {@link StandardCharsets#UTF_8 UTF-8} {@link Charset
	 * charset}.
	 *
	 * <p>
	 * This method works as if invoking it were equivalent to evaluating the
	 * expression:
	 * 
	 * <pre>
	 * {@code
	 * Files.newBufferedWriter(path, StandardCharsets.UTF_8, options)
	 * }
	 * </pre>
	 *
	 *
	 * @return a new buffered writer, with default buffer size, to write text to the
	 *         file
	 *
	 * @throws IllegalArgumentException      if {@code options} contains an invalid
	 *                                       combination of options
	 * @throws IOException                   if an I/O error occurs opening or
	 *                                       creating the file
	 * @throws UnsupportedOperationException if an unsupported option is specified
	 */
	public static Writer getWriter(String filePath) throws IOException {
		if (filePath == null) {
			throw new NullPointerException("FilePath must not be null");
		}
		return Files.newBufferedWriter(getPath(filePath));
	}

	/**
	 * Copies a file to a new location preserving the file date.
	 * <p>
	 * This method copies the contents of the specified source file to the specified
	 * destination file. The directory holding the destination file is created if it
	 * does not exist. If the destination file exists, then this method will
	 * overwrite it.
	 * <p>
	 * <strong>Note:</strong> This method tries to preserve the file's last modified
	 * date/times using {@link File#setLastModified(long)}, however it is not
	 * guaranteed that the operation will succeed. If the modification operation
	 * fails, no indication is provided.
	 *
	 * @param srcFile  an existing file to copy, must not be {@code null}
	 * @param destFile the new file, must not be {@code null}
	 *
	 * @throws NullPointerException if source or destination is {@code null}
	 * @throws IOException          if source or destination is invalid
	 * @throws IOException          if an IO error occurs during copying
	 * @throws IOException          if the output file length is not the same as the
	 */
	public static void copyFile(final File srcFile, final File destFile) throws IOException {
		FileUtils.copyFile(srcFile, destFile);
	}

}
