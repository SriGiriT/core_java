/*
 * 
 * PATH:
 * The PATH environment variable is an operating system feature used by the command shell to search for executable files or commands.
 * When you type a command into the command line interface, the shell searches through the directories listed in the PATH variable to find the executable file that matches the command.
 * In Unix-based systems (like Linux or macOS), PATH is a list of directories separated by colons (:). In Windows, it's a list separated by semicolons (;).
 * When you install software, the installer often adds the installation directory to the PATH so that you can run the installed programs from any location in the command line.
 * It's essential to manage the PATH variable carefully to ensure that the correct versions of programs are executed.
 * CLASSPATH:
 * CLASSPATH is an environment variable used by Java applications and tools to locate Java class files.
 * When you compile or run a Java program, the Java Virtual Machine (JVM) needs to know where to find the classes referenced by your code.
 * CLASSPATH can be set either as an environment variable or specified on the command line when invoking Java tools or running Java applications.
 * It is a list of directories and/or JAR files (Java ARchive files) separated by colons (Unix-based systems) or semicolons (Windows).
 * If CLASSPATH is not set, Java looks for classes in the current directory and the default system classpath.
 * It's crucial to set CLASSPATH correctly to ensure that Java programs can find the necessary classes and libraries.
 * JAVA_HOME:
 * JAVA_HOME is an environment variable used to specify the location of the Java Development Kit (JDK) or the Java Runtime Environment (JRE) on your system.
 * Many Java-based applications and development tools rely on JAVA_HOME to locate the Java installation directory.
 * Setting JAVA_HOME is particularly important when you have multiple versions of Java installed on your system, as it allows you to specify which version your applications should use.
 * JAVA_HOME should point to the root directory of your Java installation, where the bin, lib, and other directories are located.
 * It's common practice for Java developers to set JAVA_HOME in their system environment variables or in startup scripts for Java applications.
 * In summary, PATH is used by the operating system to locate executable files, CLASSPATH is used by Java applications and tools to locate class files, and JAVA_HOME is used by 
 * Java-based applications to locate the Java installation directory. Properly configuring these variables is essential for the smooth functioning of your system and Java applications.
 */
