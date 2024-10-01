package com.threeylos.core.util.common;

import java.util.Collection;

import org.apache.commons.lang3.ThreadUtils;
import org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate;
import org.apache.commons.lang3.ThreadUtils.ThreadPredicate;

/**
 * <p>
 * Helpers for {@code java.lang.Thread} and {@code java.lang.ThreadGroup}.
 * </p>
 * <p>
 * #ThreadSafe#
 * </p>
 *
 * @see java.lang.Thread
 * @see java.lang.ThreadGroup
 * @since 1.0
 * 
 * @author AbhinitKumar
 * 
 */
public class ThreadUtil {

	/**
	 * Return the active thread with the specified id if it belongs to the specified
	 * thread group.
	 *
	 * @param threadId    The thread id
	 * @param threadGroup The thread group
	 * @return The thread which belongs to a specified thread group and the thread's
	 *         id match the specified id. {@code null} is returned if no such thread
	 *         exists
	 * @throws IllegalArgumentException if the specified id is zero or negative or
	 *                                  the group is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Thread findThreadById(final long threadId, final ThreadGroup threadGroup) {
		return ThreadUtils.findThreadById(threadId, threadGroup);
	}

	/**
	 * Return the active thread with the specified id if it belongs to a thread
	 * group with the specified group name.
	 *
	 * @param threadId        The thread id
	 * @param threadGroupName The thread group name
	 * @return The threads which belongs to a thread group with the specified group
	 *         name and the thread's id match the specified id. {@code null} is
	 *         returned if no such thread exists
	 * @throws IllegalArgumentException if the specified id is zero or negative or
	 *                                  the group name is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Thread findThreadById(final long threadId, final String threadGroupName) {
		return ThreadUtils.findThreadById(threadId, threadGroupName);
	}

	/**
	 * Return active threads with the specified name if they belong to a specified
	 * thread group.
	 *
	 * @param threadName  The thread name
	 * @param threadGroup The thread group
	 * @return The threads which belongs to a thread group and the thread's name
	 *         match the specified name, An empty collection is returned if no such
	 *         thread exists. The collection returned is always unmodifiable.
	 * @throws IllegalArgumentException if the specified thread name or group is
	 *                                  null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<Thread> findThreadsByName(final String threadName, final ThreadGroup threadGroup) {
		return ThreadUtils.findThreadsByName(threadName, threadGroup);
	}

	/**
	 * Return active threads with the specified name if they belong to a thread
	 * group with the specified group name.
	 *
	 * @param threadName      The thread name
	 * @param threadGroupName The thread group name
	 * @return The threads which belongs to a thread group with the specified group
	 *         name and the thread's name match the specified name, An empty
	 *         collection is returned if no such thread exists. The collection
	 *         returned is always unmodifiable.
	 * @throws IllegalArgumentException if the specified thread name or group name
	 *                                  is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<Thread> findThreadsByName(final String threadName, final String threadGroupName) {
		return ThreadUtils.findThreadsByName(threadName, threadGroupName);
	}

	/**
	 * Return active thread groups with the specified group name.
	 *
	 * @param threadGroupName The thread group name
	 * @return the thread groups with the specified group name or an empty
	 *         collection if no such thread group exists. The collection returned is
	 *         always unmodifiable.
	 * @throws IllegalArgumentException if group name is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<ThreadGroup> findThreadGroupsByName(final String threadGroupName) {
		return ThreadUtils.findThreadGroupsByName(threadGroupName);
	}

	/**
	 * Return all active thread groups excluding the system thread group (A thread
	 * group is active if it has been not destroyed).
	 *
	 * @return all thread groups excluding the system thread group. The collection
	 *         returned is always unmodifiable.
	 * @throws SecurityException if the current thread cannot access the system
	 *                           thread group
	 *
	 * @throws SecurityException if the current thread cannot modify thread groups
	 *                           from this thread's thread group up to the system
	 *                           thread group
	 */
	public static Collection<ThreadGroup> getAllThreadGroups() {
		return ThreadUtils.getAllThreadGroups();
	}

	/**
	 * Return the system thread group (sometimes also referred as "root thread
	 * group").
	 *
	 * @return the system thread group
	 * @throws SecurityException if the current thread cannot modify thread groups
	 *                           from this thread's thread group up to the system
	 *                           thread group
	 */
	public static ThreadGroup getSystemThreadGroup() {
		return ThreadUtils.getSystemThreadGroup();
	}

	/**
	 * Return all active threads (A thread is active if it has been started and has
	 * not yet died).
	 *
	 * @return all active threads. The collection returned is always unmodifiable.
	 * @throws SecurityException if the current thread cannot access the system
	 *                           thread group
	 *
	 * @throws SecurityException if the current thread cannot modify thread groups
	 *                           from this thread's thread group up to the system
	 *                           thread group
	 */
	public static Collection<Thread> getAllThreads() {
		return ThreadUtils.getAllThreads();
	}

	/**
	 * Return active threads with the specified name.
	 *
	 * @param threadName The thread name
	 * @return The threads with the specified name or an empty collection if no such
	 *         thread exists. The collection returned is always unmodifiable.
	 * @throws IllegalArgumentException if the specified name is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<Thread> findThreadsByName(final String threadName) {
		return ThreadUtils.findThreadsByName(threadName, threadName);
	}

	/**
	 * Return the active thread with the specified id.
	 *
	 * @param threadId The thread id
	 * @return The thread with the specified id or {@code null} if no such thread
	 *         exists
	 * @throws IllegalArgumentException if the specified id is zero or negative
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 *
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Thread findThreadById(final long threadId) {
		return ThreadUtils.findThreadById(threadId);
	}

	/**
	 * <p>
	 * ThreadUtils instances should NOT be constructed in standard programming.
	 * Instead, the class should be used as {@code ThreadUtils.getAllThreads()}
	 * </p>
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean instance
	 * to operate.
	 * </p>
	 */
	public ThreadUtil() {
		super();
	}

	/**
	 * Select all active threads which match the given predicate.
	 *
	 * @param predicate the predicate
	 * @return An unmodifiable {@code Collection} of active threads matching the
	 *         given predicate
	 *
	 * @throws IllegalArgumentException if the predicate is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<Thread> findThreads(final ThreadPredicate predicate) {
		return ThreadUtils.findThreads(predicate);
	}

	/**
	 * Select all active threadgroups which match the given predicate.
	 *
	 * @param predicate the predicate
	 * @return An unmodifiable {@code Collection} of active threadgroups matching
	 *         the given predicate
	 * @throws IllegalArgumentException if the predicate is null
	 * @throws SecurityException        if the current thread cannot access the
	 *                                  system thread group
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<ThreadGroup> findThreadGroups(final ThreadGroupPredicate predicate) {
		return ThreadUtils.findThreadGroups(predicate);
	}

	/**
	 * Select all active threads which match the given predicate and which belongs
	 * to the given thread group (or one of its subgroups).
	 *
	 * @param group     the thread group
	 * @param recurse   if {@code true} then evaluate the predicate recursively on
	 *                  all threads in all subgroups of the given group
	 * @param predicate the predicate
	 * @return An unmodifiable {@code Collection} of active threads which match the
	 *         given predicate and which belongs to the given thread group
	 * @throws IllegalArgumentException if the given group or predicate is null
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<Thread> findThreads(final ThreadGroup group, final boolean recurse,
			final ThreadPredicate predicate) {
		return ThreadUtils.findThreads(group, recurse, predicate);
	}

	/**
	 * Select all active threadgroups which match the given predicate and which is a
	 * subgroup of the given thread group (or one of its subgroups).
	 *
	 * @param group     the thread group
	 * @param recurse   if {@code true} then evaluate the predicate recursively on
	 *                  all threadgroups in all subgroups of the given group
	 * @param predicate the predicate
	 * @return An unmodifiable {@code Collection} of active threadgroups which match
	 *         the given predicate and which is a subgroup of the given thread group
	 * @throws IllegalArgumentException if the given group or predicate is null
	 * @throws SecurityException        if the current thread cannot modify thread
	 *                                  groups from this thread's thread group up to
	 *                                  the system thread group
	 */
	public static Collection<ThreadGroup> findThreadGroups(final ThreadGroup group, final boolean recurse,
			final ThreadGroupPredicate predicate) {
		return ThreadUtils.findThreadGroups(group, recurse, predicate);
	}
}
