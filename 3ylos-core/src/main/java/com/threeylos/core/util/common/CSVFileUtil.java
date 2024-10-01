package com.threeylos.core.util.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * 
 * 
 * CSV file manipulation utilities.
 * <p>
 * Facilities are provided in the following areas:
 * <ul>
 * <li>writing to a CSV file
 * <li>reading from a CSV file
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
public class CSVFileUtil {

	/**
	 * Opens a {@link CSVReader} for reads the CSV records one by one into a
	 * {@link String} array.
	 *
	 * @param filePath the file to open for input, must not be {@code null}
	 * 
	 * @return a new {@link CSVReader} for the specified CSV file
	 */
	public static CSVReader getCSVReader(String filePath) {
		return getCSVReader(filePath, 0);

	}

	/**
	 * Opens a {@link CSVReader} for reads the CSV records one by one into a
	 * {@link String} array.
	 *
	 * @param filePath            the file to open for input, must not be
	 *                            {@code null}
	 * @param numberOfLinesToSkip the number lines skips to CSV file
	 * 
	 * @return a new {@link CSVReader} for the specified CSV file
	 */
	public static CSVReader getCSVReader(String filePath, int numberOfLinesToSkip) {
		CSVReaderBuilder csvReaderBuilder = null;
		try {
			csvReaderBuilder = new CSVReaderBuilder(FileUtil.getReader(filePath));
			csvReaderBuilder.withSkipLines(numberOfLinesToSkip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvReaderBuilder.build();

	}

	public static List<String[]> readAll(CSVReader reader) throws IOException, CsvException {
		if (reader == null) {
			throw new NullPointerException("CSVReader must not be null");
		}
		return reader.readAll();
	}

	/**
	 * Opens a {@link CsvToBean<T>} for read and parse the CSV records directly into
	 * your Java objects CSVReader
	 *
	 * @param filePath                the file to open for input, must not be
	 *                                {@code null}
	 * @param beanTypeBuilder         give your java object,object must not be
	 *                                {@code null}
	 * @param ignoreLeadingWhiteSpace ignore white space or not
	 * 
	 * @return a new {@link CSVReader} for the specified CSV file
	 */
	public static <T> CsvToBean<T> getCsvToBean(String filePath, Class<? extends T> beanTypeBuilder,
			Boolean ignoreLeadingWhiteSpace) {
		return getCsvToBean(filePath, beanTypeBuilder, ignoreLeadingWhiteSpace, 0);

	}

	/**
	 * Opens a {@link CsvToBean<T>} for read and parse the CSV records directly into
	 * your Java objects CSVReader
	 *
	 * @param filePath                the file to open for input, must not be
	 *                                {@code null}
	 * @param beanTypeBuilder         give your java object,object must not be
	 *                                {@code null}
	 * @param ignoreLeadingWhiteSpace ignore white space or not
	 * @param numberOfLinesToSkip     the number lines skips to CSV file
	 * 
	 * @return a new {@link CSVReader} for the specified CSV file
	 */
	public static <T> CsvToBean<T> getCsvToBean(String filePath, Class<? extends T> beanTypeBuilder,
			Boolean ignoreLeadingWhiteSpace, int numberOfLinesToSkip) {
		return getCsvToBean(filePath, beanTypeBuilder, ignoreLeadingWhiteSpace, null, 0);

	}

	/**
	 * Opens a {@link CsvToBean<T>} for read and parse the CSV records directly into
	 * your Java objects CSVReader
	 *
	 * @param filePath                the file to open for input, must not be
	 *                                {@code null}
	 * @param beanTypeBuilder         give your java object,object must not be
	 *                                {@code null}
	 * @param ignoreLeadingWhiteSpace ignore white space or not
	 * @param numberOfLinesToSkip     the number lines skips to CSV file
	 * @param mappingStrategy         to specify the mapping between CSV columns and
	 *                                Java object’s member fields, and parse the CSV
	 *                                records into Java objects.
	 * @return a new {@link <T> CsvToBean<T>} for the specified CSV file
	 * 
	 */
	public static <T> CsvToBean<T> getCsvToBean(String filePath, Class<? extends T> beanTypeBuilder,
			Boolean ignoreLeadingWhiteSpace, String[] mappingStrategy, int numberOfLinesToSkip) {

		CsvToBeanBuilder<T> csvToBean = null;
		try {
			csvToBean = new CsvToBeanBuilder<T>(FileUtil.getReader(filePath));
			csvToBean.withIgnoreLeadingWhiteSpace(ignoreLeadingWhiteSpace == null ? false : true);
			csvToBean.withType(beanTypeBuilder);
			csvToBean.withSkipLines(numberOfLinesToSkip);

			if (mappingStrategy != null) {
				ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
				strategy.setColumnMapping(mappingStrategy);
				csvToBean.withMappingStrategy(strategy);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return csvToBean.build();

	}

	/**
	 * Opens a {@link CsvToBean<T>} for read and parse the CSV records directly into
	 * your Java objects CSVReader
	 *
	 * @param filePath        the file to open for input, must not be {@code null}
	 * @param beanTypeBuilder give your java object,object must not be {@code null}
	 * 
	 * @return a new {@link <T> CsvToBean<T>} for the specified CSV file
	 * 
	 * @throws IOException if the file cannot be written to
	 */
	public static <T> CsvToBean<T> getCsvToBean(String filePath, Class<? extends T> beanTypeBuilder)
			throws IOException {
		return getCsvToBean(filePath, beanTypeBuilder, null);

	}

	/**
	 * Generate a CSV file by writing an Array of Strings into each row of the CSV
	 * file.
	 *
	 * @param filePath the file to open for input, must not be {@code null}
	 * @param datas    List Array of Strings into each row of the CSV file.
	 */
	public static void writeCSVWriter(String filePath, List<String[]> datas) throws IOException {
		CSVWriter csvWriter = null;
		try {
			csvWriter = new CSVWriter(FileUtil.getWriter(filePath), CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			csvWriter.writeAll(datas);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			csvWriter.close();
		}

	}

	/**
	 * Generate a CSV file by writing an Array of Strings into each row of the CSV
	 * file.
	 *
	 * @param filePath  the file to open for input, must not be {@code null}
	 * @param datas     List Array of Strings into each row of the CSV file.
	 * 
	 * @param separator CSV file separator like , or |
	 * 
	 * @throws IOException if the file cannot be written to
	 */
	public static void writeCSVWriter(String filePath, char separator, List<String[]> datas) throws IOException {
		CSVWriter csvWriter = null;
		try {
			csvWriter = new CSVWriter(FileUtil.getWriter(filePath), separator, CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			csvWriter.writeAll(datas);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			csvWriter.close();
		}

	}

	/**
	 * Generate a CSV file from List of objects
	 *
	 * @param filePath        the file to open for input, must not be {@code null}
	 * @param beanTypeBuilder CSV records directly into your Java objects.
	 * 
	 */
	public static <T> void writeStatefulBeanToCsv(String filePath, List<T> beanTypeBuilder) {
		StatefulBeanToCsv<T> beanToCsv = null;
		try {
			StatefulBeanToCsvBuilder<T> statefulBeanToCsvBuilder = new StatefulBeanToCsvBuilder<>(
					FileUtil.getWriter(filePath));
			beanToCsv = statefulBeanToCsvBuilder.build();
			beanToCsv.write(beanTypeBuilder);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Generate a CSV file from List of objects
	 *
	 * @param writer          the writer to open for input, must not be {@code null}
	 * @param beanTypeBuilder CSV records directly into your Java objects.
	 * 
	 */
	public static <T> void writeStatefulBeanToCsv(PrintWriter writer, List<T> beanTypeBuilder) {
		StatefulBeanToCsv<T> beanToCsv = null;
		try {
			StatefulBeanToCsvBuilder<T> statefulBeanToCsvBuilder = new StatefulBeanToCsvBuilder<>(writer);
			beanToCsv = statefulBeanToCsvBuilder.build();
			beanToCsv.write(beanTypeBuilder);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}

	}

}
