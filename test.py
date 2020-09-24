import speech_recognition
from datetime import date
from datetime import datetime
import pyttsx3
robot_mouth = pyttsx3.init()
robot_ear = speech_recognition.Recognizer()
robot_brain = ""
while True:
    with speech_recognition.Microphone() as mic:
       print("robot: i'm listening.....")
       audio  = robot_ear.listen(mic)
       try:
            you  = robot_ear.recognize_google(audio)
       except :
           you = ""
       print("you:"+you)
    if "hello" in you:
            robot_brain = "hello my boss"
            print("result:"+robot_brain)
    elif "ready" in you:
            robot_brain = "i always ready to answer your question"
            print("result:"+robot_brain)
    elif "today" in you:
            today = date.today()
            robot_brain= today.strftime("%B %d, %Y")
            print("result:"+robot_brain)
    elif "time" in you:
            now = datetime.now()
            robot_brain = now.strftime("%H:%M:%S")
            print("result:"+robot_brain)
    elif "president" in you:
            robot_brain = "the president of america is donal trump"
            print("result:"+robot_brain)
    elif "boss" in you:
            robot_brain = " my boss is Dương Hữu Khánh"
            print("result:"+robot_brain)
    elif " love" in you:
            robot_brain = "of course i always love you so much"
            print("result:"+robot_brain)
    elif "bye" in you:
            robot_brain = "ok good bye see you again,....i hope you have good experience with virtual assitant "
            print(robot_brain)
            robot_mouth.say(robot_brain)
            robot_mouth.runAndWait()
            break
    else :
            robot_brain = "i can't hear any thing,try it again"
            print("result:"+robot_brain)
    robot_mouth.say(robot_brain)
    robot_mouth.runAndWait()