# springbatchone
first spring batch project



#Create Schema Spring_batch 

CREATE TABLE BATCH_JOB_INSTANCE  (
    JOB_INSTANCE_ID NUMBER(19,0)  NOT NULL PRIMARY KEY ,
    VERSION NUMBER(19,0) ,
    JOB_NAME VARCHAR2(100 char) NOT NULL,
    JOB_KEY VARCHAR2(32 char) NOT NULL,
    constraint JOB_INST_UN unique (JOB_NAME, JOB_KEY)
) ;

CREATE TABLE BATCH_JOB_EXECUTION  (
    JOB_EXECUTION_ID NUMBER(19,0)  NOT NULL PRIMARY KEY ,
    VERSION NUMBER(19,0)  ,
    JOB_INSTANCE_ID NUMBER(19,0) NOT NULL,
    CREATE_TIME TIMESTAMP NOT NULL,
    START_TIME TIMESTAMP DEFAULT NULL ,
    END_TIME TIMESTAMP DEFAULT NULL ,
    STATUS VARCHAR2(10 char) ,
    EXIT_CODE VARCHAR2(2500 char) ,
    EXIT_MESSAGE VARCHAR2(2500 char) ,
    LAST_UPDATED TIMESTAMP,
    JOB_CONFIGURATION_LOCATION VARCHAR(2500 char) NULL,
    constraint JOB_INST_EXEC_FK foreign key (JOB_INSTANCE_ID)
    references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)
) ;

CREATE TABLE BATCH_JOB_EXECUTION_PARAMS  (
    JOB_EXECUTION_ID NUMBER(19,0) NOT NULL ,
    TYPE_CD VARCHAR2(6 char) NOT NULL ,
    KEY_NAME VARCHAR2(100 char) NOT NULL ,
    STRING_VAL VARCHAR2(250 char) ,
    DATE_VAL TIMESTAMP DEFAULT NULL ,
    LONG_VAL NUMBER(19,0) ,
    DOUBLE_VAL NUMBER ,
    IDENTIFYING CHAR(1) NOT NULL ,
    constraint JOB_EXEC_PARAMS_FK foreign key (JOB_EXECUTION_ID)
    references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ;

CREATE TABLE BATCH_STEP_EXECUTION  (
    STEP_EXECUTION_ID NUMBER(19,0)  NOT NULL PRIMARY KEY ,
    VERSION NUMBER(19,0) NOT NULL,
    STEP_NAME VARCHAR2(100 char) NOT NULL,
    JOB_EXECUTION_ID NUMBER(19,0) NOT NULL,
    START_TIME TIMESTAMP NOT NULL ,
    END_TIME TIMESTAMP DEFAULT NULL ,
    STATUS VARCHAR2(10 char) ,
    COMMIT_COUNT NUMBER(19,0) ,
    READ_COUNT NUMBER(19,0) ,
    FILTER_COUNT NUMBER(19,0) ,
    WRITE_COUNT NUMBER(19,0) ,
    READ_SKIP_COUNT NUMBER(19,0) ,
    WRITE_SKIP_COUNT NUMBER(19,0) ,
    PROCESS_SKIP_COUNT NUMBER(19,0) ,
    ROLLBACK_COUNT NUMBER(19,0) ,
    EXIT_CODE VARCHAR2(2500 char) ,
    EXIT_MESSAGE VARCHAR2(2500 char) ,
    LAST_UPDATED TIMESTAMP,
    constraint JOB_EXEC_STEP_FK foreign key (JOB_EXECUTION_ID)
    references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
);

CREATE TABLE BATCH_STEP_EXECUTION_CONTEXT  (
    STEP_EXECUTION_ID NUMBER(19,0) NOT NULL PRIMARY KEY,
    SHORT_CONTEXT VARCHAR2(2500 char) NOT NULL,
    SERIALIZED_CONTEXT CLOB ,
    constraint STEP_EXEC_CTX_FK foreign key (STEP_EXECUTION_ID)
    references BATCH_STEP_EXECUTION(STEP_EXECUTION_ID)
);

CREATE TABLE  BATCH_JOB_EXECUTION_CONTEXT (
JOB_EXECUTION_ID NUMBER(19,0) NOT NULL PRIMARY KEY,
SHORT_CONTEXT VARCHAR2(2500 char) NOT NULL,
SERIALIZED_CONTEXT CLOB ,
constraint JOB_EXEC_CTX_FK foreign key (JOB_EXECUTION_ID)
references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
);


CREATE SEQUENCE BATCH_STEP_EXECUTION_SEQ START WITH 0 MINVALUE 0 MAXVALUE 9223372036854775807 NOCYCLE;
CREATE SEQUENCE BATCH_JOB_EXECUTION_SEQ START WITH 0 MINVALUE 0 MAXVALUE 9223372036854775807 NOCYCLE;
CREATE SEQUENCE BATCH_JOB_SEQ START WITH 0 MINVALUE 0 MAXVALUE 9223372036854775807 NOCYCLE;

#By specifying the INITRANS and MAXTRANS parameters during the creation of each table, you can affect how much space is initially and can ever be allocated for transaction entries in the data blocks of a table's data segment



-------------------------------

Delete from SPRING_BATCH.BATCH_STEP_EXECUTION_CONTEXT;
Delete from SPRING_BATCH.BATCH_JOB_EXECUTION_CONTEXT;
Delete from SPRING_BATCH.BATCH_STEP_EXECUTION;
Delete from SPRING_BATCH.BATCH_JOB_EXECUTION;
Delete from SPRING_BATCH.BATCH_JOB_INSTANCE;






MARIADB:
-------------------------------------------------------------------

CREATE TABLE BATCH_JOB_INSTANCE  (
JOB_INSTANCE_ID BIGINT  NOT NULL PRIMARY KEY ,
VERSION BIGINT ,
JOB_NAME VARCHAR(100) NOT NULL,
JOB_KEY VARCHAR(32) NOT NULL,
constraint JOB_INST_UN unique (JOB_NAME, JOB_KEY)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION  (
JOB_EXECUTION_ID BIGINT  NOT NULL PRIMARY KEY ,
VERSION BIGINT  ,
JOB_INSTANCE_ID BIGINT NOT NULL,
CREATE_TIME DATETIME(6) NOT NULL,
START_TIME DATETIME(6) DEFAULT NULL ,
END_TIME DATETIME(6) DEFAULT NULL ,
STATUS VARCHAR(10) ,
EXIT_CODE VARCHAR(2500) ,
EXIT_MESSAGE VARCHAR(2500) ,
LAST_UPDATED DATETIME(6),
JOB_CONFIGURATION_LOCATION VARCHAR(2500) NULL,
constraint JOB_INST_EXEC_FK foreign key (JOB_INSTANCE_ID)
references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION_PARAMS  (
JOB_EXECUTION_ID BIGINT NOT NULL ,
TYPE_CD VARCHAR(6) NOT NULL ,
KEY_NAME VARCHAR(100) NOT NULL ,
STRING_VAL VARCHAR(250) ,
DATE_VAL DATETIME(6) DEFAULT NULL ,
LONG_VAL BIGINT ,
DOUBLE_VAL DOUBLE PRECISION ,
IDENTIFYING CHAR(1) NOT NULL ,
constraint JOB_EXEC_PARAMS_FK foreign key (JOB_EXECUTION_ID)
references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION  (
STEP_EXECUTION_ID BIGINT  NOT NULL PRIMARY KEY ,
VERSION BIGINT NOT NULL,
STEP_NAME VARCHAR(100) NOT NULL,
JOB_EXECUTION_ID BIGINT NOT NULL,
START_TIME DATETIME(6) NOT NULL ,
END_TIME DATETIME(6) DEFAULT NULL ,
STATUS VARCHAR(10) ,
COMMIT_COUNT BIGINT ,
READ_COUNT BIGINT ,
FILTER_COUNT BIGINT ,
WRITE_COUNT BIGINT ,
READ_SKIP_COUNT BIGINT ,
WRITE_SKIP_COUNT BIGINT ,
PROCESS_SKIP_COUNT BIGINT ,
ROLLBACK_COUNT BIGINT ,
EXIT_CODE VARCHAR(2500) ,
EXIT_MESSAGE VARCHAR(2500) ,
LAST_UPDATED DATETIME(6),
constraint JOB_EXEC_STEP_FK foreign key (JOB_EXECUTION_ID)
references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION_CONTEXT  (
STEP_EXECUTION_ID BIGINT NOT NULL PRIMARY KEY,
SHORT_CONTEXT VARCHAR(2500) NOT NULL,
SERIALIZED_CONTEXT TEXT ,
constraint STEP_EXEC_CTX_FK foreign key (STEP_EXECUTION_ID)
references BATCH_STEP_EXECUTION(STEP_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION_CONTEXT  (
JOB_EXECUTION_ID BIGINT NOT NULL PRIMARY KEY,
SHORT_CONTEXT VARCHAR(2500) NOT NULL,
SERIALIZED_CONTEXT TEXT ,
constraint JOB_EXEC_CTX_FK foreign key (JOB_EXECUTION_ID)
references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION_SEQ (
ID BIGINT NOT NULL,
UNIQUE_KEY CHAR(1) NOT NULL,
constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

INSERT INTO BATCH_STEP_EXECUTION_SEQ (ID, UNIQUE_KEY) select * from (select 0 as ID, '0' as UNIQUE_KEY) as tmp where not exists(select * from BATCH_STEP_EXECUTION_SEQ);

CREATE TABLE BATCH_JOB_EXECUTION_SEQ (
ID BIGINT NOT NULL,
UNIQUE_KEY CHAR(1) NOT NULL,
constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

INSERT INTO BATCH_JOB_EXECUTION_SEQ (ID, UNIQUE_KEY) select * from (select 0 as ID, '0' as UNIQUE_KEY) as tmp where not exists(select * from BATCH_JOB_EXECUTION_SEQ);

CREATE TABLE BATCH_JOB_SEQ (
ID BIGINT NOT NULL,
UNIQUE_KEY CHAR(1) NOT NULL,
constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

INSERT INTO BATCH_JOB_SEQ (ID, UNIQUE_KEY) select * from (select 0 as ID, '0' as UNIQUE_KEY) as tmp where not exists(select * from BATCH_JOB_SEQ);

----

DROP TABLE IF EXISTS BATCH_STEP_EXECUTION_CONTEXT;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION_CONTEXT;
DROP TABLE IF EXISTS BATCH_STEP_EXECUTION;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION_PARAMS;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION;
DROP TABLE IF EXISTS BATCH_JOB_INSTANCE;
DROP TABLE IF EXISTS BATCH_STEP_EXECUTION_SEQ;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION_SEQ;
DROP TABLE IF EXISTS BATCH_JOB_SEQ;

---

Delete from spring_batch.BATCH_STEP_EXECUTION_CONTEXT;
Delete from spring_batch.BATCH_JOB_EXECUTION_CONTEXT;
Delete from spring_batch.BATCH_STEP_EXECUTION;
Delete from spring_batch.BATCH_JOB_EXECUTION;
Delete from spring_batch.BATCH_JOB_INSTANCE;


-------------------------------------------------------------------









--- . --- . --- . --- . --- . --- . --- . --- . --- . ---

Notes:

SEMAPHORE:
    -it is a signalling mechanism
    -threads and processes perform wait() and notify() operations to indicate whether they are acquiring or releasing the resource.
    -semaphore allows multiple program threads to access the finite instance of resources(not just a single resource)
    -the process or thread blocks itself if no resource is free till the count of semaphore become greater than 0 

MUTEX:
    -mutex is a locking mechanism
    -threads or processes have to acquire the lock on mutex object if wants to acquire the resource
    -mutex allows multiple program threads to access a single shared resource but one at a time.
    -if the lock is already acquired by another thread or process then the thread will wait until the mutex object gets unlocked


Runnable and Callable Interface:
-Runnable: a so called run-and-forget action. we execute a given operation in run() method without a return value.

-Callable<T>: we use Callable interface's call() method if we want to return a given value from the given thread
    -Callable interface will not return value: this is why we  need Future<T> object.
    -calling thread will be blocked till the call() method is executed and Future<T> return the results

-The ExecutorService can handle both of the interfaces (Runnable and Callable interfaces)
    -executorService.execute():
        -this method executes a Runnable interface, 
         so it means there is no return value (void run() method)
    -executorService.submit():
        -this method can handle Runnable interfaces as well as Callable interfaces
            -it can handle a Future<T> return value and we can get the T value with get() on the future object.

-Latch: 
    -this is used to synchronize one or more tasks by forcing them to wait for the completion of a set of operation 
     being performed by other tasks.
    -you give an initial to a CountDownLatch object, and any task that calls await() on that object will block until 
     the count reaches zero.
    -the tasks that call countDown() are not blocked when they make that call. only the call to await() is blocked
     until the count reaches zero.

-Cyclic barrier:
    -Latch -> multiple threads can wait for each other
    -a cyclic barrier is used in a situation where you wait to create a group of tasks to perform work in parallel 
     plus wait until they are all finished before moving on to the next step
        -something like join()
        -something like CountDownLatch
        -CountDownLatch: one-shot event, it reaches zero it is over
        -CyclicBarrier: it can be reused over and over again
            +cyclicBarrier has a barrier action: a runnable, that will run automatically when the count reaches 0
    -New CyclicBarrier(N) -> N threads will wait for each other
    -we can not reuse latches but we can reuse cyclicBarrier -> react()

-BlockingQueue:
    -BlockingQueue -> an interface that represents a queue that is thread safe put items or take item from it.
        -for example: one thread putting item into the queue and another thread taking items from it at the same time.
            -we can do it with producer-consumer pattern
    -put() putting items to the queue
    -take() taking items from the queue


-Delay Queue:
    -this is an unbounded blockingqueue of objects that implement the Delayed interface
    -DelayQueue keeps the elements internally until a certain delay has expired
    -an object can only be taken from the queue when its delay has expired
    -we cannot place null items in the queue - the queue is sorted so that
     the object at the head has a delay that has expired for longest time.
    -if no delay has expired, then there is no head element and poll() will return null
    -size() return the count of both expired and unexpired items


-Priority Queue:
    -it implements the BlockingQueue interface
    -unbound concurrent queue
    -it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the comparable interface
        -the comparable interface will determine what will the order in the queue
        -the priority can be the same compare() === 0 case
    -no null item


-Concurrent map:


-Exchanger:
    -with help of exchanger two thread can exchange objects
    -exchange() -> exchanging objects is done via one of two exchange()
    -for example: a genetic algorithm, training neural networks 