/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: package-info.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-10 上午9:34:11
 * @Version v1.0
 */
/**
 * TODO
 * @ClassName: package-info
 * @author jason.liu
 */
package com.appframework.examples.concurrency;

/**
 * It's becoming more and more common for computer systems to have multiple processors or processors with multiple execution cores. This greatly enhances a system's capacity for concurrent execution of processes and threads — but concurrency is possible even on simple systems, without multiple processors or execution cores.
 */

/**
 * There are two basic strategies for using Thread objects to create a concurrent application.

 To directly control thread creation and management, simply instantiate Thread each time the application needs to initiate an asynchronous task.
 To abstract thread management from the rest of your application, pass the application's tasks to an executor.
 */

/**
 * Thread.sleep causes the current thread to suspend execution for a specified period. 
 */
// Most implementations of the Java virtual machine run as a single process.

/**
 * Thread Interference describes how errors are introduced when multiple threads
 * access shared data.
 * Memory Consistency Errors describes errors that result
 * from inconsistent views of shared memory.
 */

/**
 * Memory consistency errors occur when different threads have inconsistent views of what should be the same data. The causes of memory consistency errors are complex and beyond the scope of this tutorial. Fortunately, the programmer does not need a detailed understanding of these causes. All that is needed is a strategy for avoiding them.
 * The key to avoiding memory consistency errors is understanding the happens-before relationship. This relationship is simply a guarantee that memory writes by one specific statement are visible to another specific statement.
 */


/**
 * The Java programming language provides two basic synchronization idioms: synchronized methods and synchronized statements.
 * */
