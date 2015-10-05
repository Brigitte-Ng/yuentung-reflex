This is an assignment for CMPUT 301.

There are 2 modes in this app, Single user mode and Gameshow buzzer mode.

1) Single user mode:
When the user enters this mode they prompted with information that says they how to supposed to react quickly. Once the user dismisses the information prompt the reaction time game starts.

The game waits between 10ms and 2000ms before prompts the user to click. If the user clicks too early the game complains and restarts the timer. The user doesn't see the timer. When the wait is over the game tells the user to click. When the user clicks, the latency between the end of the wait and when the user clicked is recorded and shown to the user briefly. The game game restarts. If the user wants to quit they can just press the back button.

2) Gameshow buzzer mode:
This is meant to aid friends playing a trivia game or a game that needs to determine who has the answer first. When a question is asked of the friends, the first one to press their button should be notified that they were indeed first.

When one enters the gameshow mode, the system should ask the user how many players (at least 2, 3, or 4 players). Once selected, a buzzer screen should appear with the necessary number of buttons on it for each player, displayed as big as possible. When a button is pressed it should show everyone who pressed the button (e.g., player 1). The system will record who pressed the button first and the number of players. By dismissing the message it should return to the buzzer screen.

Users can view statistics about their reaction times and buzzer use. A user should be able to navigate to a statistical display screen that shows:
	▪	Reaction time statistics:
	◦	minimum time of all reaction times, the last 10 times, and the last 100 times.
	◦	maximum time of all reaction times, the last 10 times, and the last 100 times.
	◦	average time of all reaction times, the last 10 times, and the last 100 times.
	◦	median time of all reaction times, the last 10 times, and the last 100 times.
	•	Buzzer counts
	◦	2 player: Player 1 buzzes, Player 2 buzzes
	◦	3 player: Player 1 buzzes, Player 2 buzzes, Player 3 buzzes
	◦	4 player: Player 1 buzzes, Player 2 buzzes, Player 3 buzzes, Player 4 buzzes
	
Demo:
https://youtu.be/97PrT4ed5RQ

References:
http://stackoverflow.com/questions/4597690/android-timer-how
http://stackoverflow.com/questions/2115758/how-to-display-alert-dialog-in-android
http://stackoverflow.com/questions/8227820/alert-dialog-two-buttons
http://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity
http://stackoverflow.com/questions/17810044/android-create-json-array-and-json-object


