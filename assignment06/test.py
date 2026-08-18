import threading

def Thread1():

    for i in range(0,100):

        if i % 2 == 0:

            print("Thread 1 : ",+i)

def Thread2():

    for i in range(0,100):

        if i % 2 == 1:

            print("Thread 2 : ",+i)




thread1 = threading.Thread(target = Thread1)
thread2 = threading.Thread(target = Thread2)

thread1.start()
thread2.start()

thread1.join()
thread2.join()