#include <Servo.h>

Servo myservoLeft;
Servo myservoRight;
const int pingPin = 7;
unsigned long lastObstacleTime = 0; // Variable to track the time when an obstacle was last detected
const unsigned long obstacleTimeout = 2000; // Threshold for considering the robot held up (2 seconds)

void setup() {
Serial.begin(9600);
myservoLeft.attach(10);
myservoRight.attach(11);
}

void loop() {
long duration, cm;

// Send a pulse to the ultrasonic sensor
pinMode(pingPin, OUTPUT);
digitalWrite(pingPin, LOW);
delayMicroseconds(2);
digitalWrite(pingPin, HIGH);
delayMicroseconds(5);
digitalWrite(pingPin, LOW);

// Measure the duration of the pulse returned by the sensor
pinMode(pingPin, INPUT);
duration = pulseIn(pingPin, HIGH);

// Convert the duration to centimeters
cm = microsecondsToCentimeters(duration);
Serial.print(cm);
Serial.print("cm");
Serial.println();
delay(50);

// Logic for obstacle avoidance
if (cm <= 10) {
    // If an obstacle is detected within 10 cm, go backwards
    myservoLeft.writeMicroseconds(1400);
    myservoRight.writeMicroseconds(1900);

    // Check if the obstacle has held up the robot for too long
    if (millis() - lastObstacleTime > obstacleTimeout) {
        // Perform turning action
        turnLeft(); // Implement your turning logic here
        // Update the time when the obstacle was last detected
        lastObstacleTime = millis();
    }

    delay(1100); // Move backward for 1.1 seconds
} else {
    // If no obstacle is detected, move forward
    myservoLeft.writeMicroseconds(1600); // Move left servo forward
    myservoRight.writeMicroseconds(1400); // Move right servo forward
}
}

// Function to convert microseconds to centimeters
long microsecondsToCentimeters(long microseconds) {
// Speed of sound is approximately 29 microseconds per centimeter
return microseconds / 29 / 2; // Divide by 2 because the sound travels back and forth
}

// Function to turn left
void turnLeft() {
// Stop the robot
myservoLeft.writeMicroseconds(1500);
myservoRight.writeMicroseconds(1500);
delay(500); // Delay to stop the robot completely

// Perform left turn
myservoLeft.writeMicroseconds(1400);
myservoRight.writeMicroseconds(1400);
delay(500); // Adjust this delay as needed for your turning maneuver
}

// Function to turn right
void turnRight() {
// Stop the robot
myservoLeft.writeMicroseconds(1500);
myservoRight.writeMicroseconds(1500);
delay(500); // Delay to stop the robot completely

// Perform right turn
myservoLeft.writeMicroseconds(1600);
myservoRight.writeMicroseconds(1600);
delay(500); // Adjust this delay as needed for your turning maneuver
}
