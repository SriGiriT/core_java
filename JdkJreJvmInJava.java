/*
 * 
 * JDK (.java)
 * Java Development kit
 * It's used for development for java ( which contains javac)
 * Development tools + JRE
 * (which is available in bin folder)
 * we need to add the jdk files to the environmental variable to let the application know that where java is currently available 
 * by that they can able to load the development tools 
 * the development tools needed for the compilation ( javac ), interpreter/loader (java), archiver (jar), documentation generator (javadoc)
 * 
 * JRE (.class)
 * Java Runtime Environment
 * Runtime tools and libraries( java internal classes)
 * Provide runtime environment for execution of java programs
 * jre contains java only (not javac) since we need to compile only when we develop program 
 * java need to run program so it was provided with the jre 
 * provides resources and environment to run java program 
 * in the lib folder under jre we have lot of jar files 
 * one of the important jar file is called as rt.jar
 * which contains all the default package that java program required
 * 
 * 
 * JVM 
 * Java Virtual Machine
 * contains class loader subsystem, runtime data areas, execution engine, native libraries
 * (machine understandable code / interpreted bytecode)
 * Class loader subsystem 
 * class file enters JVM first it get into class loader subsystem 
 * class loader subsystem consist of 3 major parts 
 * Loading, linking, initialization
 * loading occurs as three steps (bootstrap loader , extension loader, application class loader)
 * while jre loads all the classes into memory with the help of class loader we can able to what we need at the particular time
 * bootstrap class loader 
 * bootstrap class loader is written in native code, so it behavior is different
 * the classes are loaded by the instance of java.land.ClassLoader and bootstrap class loader loads that class itself
 * it's also responsible to load jdk internal classes, typically rt.jar and other core libraries 
 * which loads $JAVA_HOME/jre/lib directory
 * 
 * extension loader
 * extension class load classes that are an extension of the standard core java classes
 * which loads $JAVA_HOME/lib/ext directory
 *  
 * application loader 
 * application or system class loader loads our own file in the class path
 * which take care of loading all application level classes
 *  
 * Class Loader 
 * class loader is a part of java runtime environment. when the jvm requests a class. the class loader 
 * (java.lang.ClassLoader.loadClass()) tries to locate the class and 
 * load the class definition into the runtime using the fully qualified class name.
 * 
 * Linking
 * Verify, prepare, resolve
 * check for the bytecode (.class file)
 * prepare (initialize the static variables with default values)
 * resolve (changes symbolic references to method references) (changes all things from constant pool to runtime constant pool)
 * 
 * Initialization 
 * will allocate original values to the static variables
 * 
 * 
 * 
 * Runtime data areas (Memory area)
 * Java divided the alocated memory from the os as three types
 * stack, heap, metaspace/permenant generation(permGen)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Execution Engine
 * interpreter
 * Just in time compiler 
 * garbage collection
 * native method interface(JNI)
 * Native method Library
 * 
 */

