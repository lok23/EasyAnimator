# EasyAnimator
https://user-images.githubusercontent.com/45181211/147004188-6cf93f07-837d-4cfc-a060-88ef385d5cdf.mp4

https://user-images.githubusercontent.com/45181211/147004197-f694887d-5905-4e9b-a635-dd8222a23381.mp4

# What is this?
This is the final project for CS 5004 Object Oriented Design (OOD). The purpose of this final project is to demonstrate our understanding of Object Oriented Design Principles and the MVC pattern. This program takes in user input (speed, text input, output type), text input (shapes, colors, sizes, movements) and can produce 1 of 3 outputs:

## 1) Plain text output describing their movements
![text](https://user-images.githubusercontent.com/45181211/146989738-2f159468-39a3-4a59-9216-dd5fa5f5abb7.PNG)

## 2) SVG which can be run in an SVG viewer and viewed visually
![svg](https://user-images.githubusercontent.com/45181211/146990391-4a9f7d66-02f7-4cc1-a139-b5dd616f7f94.PNG)

<br>

https://user-images.githubusercontent.com/45181211/146990646-3f72671b-4212-4954-be88-1d60046c07b3.mp4

## 3) A GUI which runs the animation
https://user-images.githubusercontent.com/45181211/146989570-eb33f8e3-4ffb-4f05-aecb-51a77422dfbe.mp4

## Purpose
The purpose of this project is to demonstrate our mastery of the MVC (Model View Controller) pattern. 

The model is responsible for tracking the internal logic of the program. This includes creating shapes, moving shapes, changing colors, etc. 

The controller is responsible for mediating the interactions between the view and the model. Put more concretely, the controller is responsible for taking in the user input, sending that information to the model for processing, and then returning an output view dependent on that user input. 

The view is responsible for displaying information back to the user. In our case, we have 3 different views representing the 3 different outputs (Plain text, SVG, GUI). 

The MVC design pattern proved to be a very useful pattern by separating out code into discrete units. This made writing tests easier, and made understanding code much easier, as I am able to understand what each class does well enough to write this README.md, even though it is nearly 2 years since I initially wrote the code.

## How to Run
After downloading the repo, in the command line navigate to out/artifacts/Assignment8Remastered_jar. In the command line, choose which of the .txt files you want to use as input, then choose 1 of 3 view types ("text", "visual", "svg"), then pick an output name, then pick a speed at which the animations will be rendered. Here are some examples:
<br>

`java -jar Assignment8Remastered.jar -in smalldemo.txt -view text -out out -speed 20`

`java -jar Assignment8Remastered.jar -in buildings.txt -view visual -out out -speed 50`

## Credits
All credits to:

https://www.youtube.com/watch?v=GvTZ2Huo0T4

https://www.youtube.com/watch?v=M4DJTP6TG94&list=PLI2uiPwn6f39OGDEv5wA_d9yhHYlNye06

And countless stackoverflow answers
