F:\IdeaWorkSpace\JavaCamp\Work>jps -l
13984 org.jetbrains.idea.maven.server.RemoteMavenServer36
7936
16116 sun.tools.jps.Jps
14748 gateway-server-0.0.1-SNAPSHOT.jar

F:\IdeaWorkSpace\JavaCamp\Work>jstat -l 14748
Unknown option: -l
Usage: jstat -help|-options
       jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]

Definitions:
  <option>      An option reported by the -options option
  <vmid>        Virtual Machine Identifier. A vmid takes the following form:
                     <lvmid>[@<hostname>[:<port>]]
                Where <lvmid> is the local vm identifier for the target
                Java virtual machine, typically a process id; <hostname> is
                the name of the host running the target Java virtual machine;
                and <port> is the port number for the rmiregistry on the
                target host. See the jvmstat documentation for a more complete
                description of the Virtual Machine Identifier.
  <lines>       Number of samples between header lines.
  <interval>    Sampling interval. The following forms are allowed:
                    <n>["ms"|"s"]
                Where <n> is an integer and the suffix specifies the units as
                milliseconds("ms") or seconds("s"). The default units are "ms".
  <count>       Number of samples to take before terminating.
  -J<flag>      Pass <flag> directly to the runtime system.

F:\IdeaWorkSpace\JavaCamp\Work>jstack -l 14748
2021-07-03 22:36:11
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):

"DestroyJavaVM" #33 prio=5 os_prio=0 tid=0x000000001fa75000 nid=0x2ba0 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"http-nio-8088-AsyncTimeout" #31 daemon prio=5 os_prio=0 tid=0x000000001fa74800 nid=0x352c waiting on condition [0x0000000024d7f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.coyote.AbstractProtocol$AsyncTimeout.run(AbstractProtocol.java:1143)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-Acceptor-0" #30 daemon prio=5 os_prio=0 tid=0x000000001fa73800 nid=0x3df8 runnable [0x0000000024ebf000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.ServerSocketChannelImpl.accept0(Native Method)
        at sun.nio.ch.ServerSocketChannelImpl.accept(Unknown Source)
        at sun.nio.ch.ServerSocketChannelImpl.accept(Unknown Source)
        - locked <0x0000000784f6cdf0> (a java.lang.Object)
        at org.apache.tomcat.util.net.NioEndpoint$Acceptor.run(NioEndpoint.java:455)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-ClientPoller-1" #29 daemon prio=5 os_prio=0 tid=0x000000001fa73000 nid=0x3008 runnable [0x0000000024c1e000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x00000007851aecd0> (a sun.nio.ch.Util$3)
        - locked <0x00000007851aecc0> (a java.util.Collections$UnmodifiableSet)
        - locked <0x00000007851aeb70> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:798)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-ClientPoller-0" #28 daemon prio=5 os_prio=0 tid=0x000000001fa72000 nid=0x29c4 runnable [0x0000000024adf000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x00000007851aaa78> (a sun.nio.ch.Util$3)
        - locked <0x00000007851aaa68> (a java.util.Collections$UnmodifiableSet)
        - locked <0x00000007851aa918> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:798)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-10" #27 daemon prio=5 os_prio=0 tid=0x000000001fa71800 nid=0x3720 waiting on condition [0x000000002454e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-9" #26 daemon prio=5 os_prio=0 tid=0x000000001fa70800 nid=0x2df4 waiting on condition [0x000000002498f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-8" #25 daemon prio=5 os_prio=0 tid=0x000000001fa70000 nid=0x984 waiting on condition [0x000000002480e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-7" #24 daemon prio=5 os_prio=0 tid=0x000000001fa6f000 nid=0xa40 waiting on condition [0x000000002466e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-6" #23 daemon prio=5 os_prio=0 tid=0x000000001fa6e800 nid=0x363c waiting on condition [0x0000000023dee000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-5" #22 daemon prio=5 os_prio=0 tid=0x0000000007576000 nid=0x3be0 waiting on condition [0x000000002439f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-4" #21 daemon prio=5 os_prio=0 tid=0x0000000007575000 nid=0x1f64 waiting on condition [0x000000002420f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-3" #20 daemon prio=5 os_prio=0 tid=0x0000000007574800 nid=0x9b8 waiting on condition [0x00000000240bf000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-2" #19 daemon prio=5 os_prio=0 tid=0x0000000007573800 nid=0x2c6c waiting on condition [0x0000000023efe000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-1" #18 daemon prio=5 os_prio=0 tid=0x0000000007573000 nid=0x9c8 waiting on condition [0x0000000021bbe000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000784fd5c90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"NioBlockingSelector.BlockPoller-1" #17 daemon prio=5 os_prio=0 tid=0x0000000007572000 nid=0x32bc runnable [0x0000000023c0e000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x0000000784f6f8e0> (a sun.nio.ch.Util$3)
        - locked <0x0000000784f6f858> (a java.util.Collections$UnmodifiableSet)
        - locked <0x0000000784f6f458> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioBlockingSelector$BlockPoller.run(NioBlockingSelector.java:298)

   Locked ownable synchronizers:
        - None

"container-0" #16 prio=5 os_prio=0 tid=0x0000000007571800 nid=0x3694 waiting on condition [0x000000001f4ff000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.catalina.core.StandardServer.await(StandardServer.java:427)
        at org.springframework.boot.web.embedded.tomcat.TomcatWebServer$1.run(TomcatWebServer.java:182)

   Locked ownable synchronizers:
        - None

"ContainerBackgroundProcessor[StandardEngine[Tomcat]]" #15 daemon prio=5 os_prio=0 tid=0x0000000007570800 nid=0x3d6c waiting on condition [0x000000002390f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1357)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"Service Thread" #9 daemon prio=9 os_prio=0 tid=0x0000000006085800 nid=0x1038 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C1 CompilerThread2" #8 daemon prio=9 os_prio=2 tid=0x0000000005ffd800 nid=0x1db0 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=2 tid=0x0000000005ffa800 nid=0x329c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=2 tid=0x0000000004d7f000 nid=0x1b9c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000005fe9800 nid=0x2154 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000005fe8800 nid=0x3e64 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000004d5a000 nid=0x9fc in Object.wait() [0x0000000005d6e000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x0000000709306ed0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(Unknown Source)
        - locked <0x0000000709306ed0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(Unknown Source)
        at java.lang.ref.Finalizer$FinalizerThread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000004d12800 nid=0x143c in Object.wait() [0x0000000005fdf000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x0000000709306e38> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Unknown Source)
        at java.lang.ref.Reference.tryHandlePending(Unknown Source)
        - locked <0x0000000709306e38> (a java.lang.ref.Reference$Lock)
        at java.lang.ref.Reference$ReferenceHandler.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"VM Thread" os_prio=2 tid=0x0000000004d0a800 nid=0x3bb4 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x000000000248d000 nid=0x2564 runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x000000000248e800 nid=0xa14 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002490000 nid=0x3450 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002493800 nid=0x24c8 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x00000000060b7800 nid=0x2714 waiting on condition

JNI global references: 928


