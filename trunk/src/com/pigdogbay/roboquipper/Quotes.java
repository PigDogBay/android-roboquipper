package com.pigdogbay.roboquipper;

import java.util.Random;

public final class Quotes
{
	static String _Quotes[] = {
			"Well give the man a hand!",
			"Can you fly, Bobby?",
			"I'd buy that for a dollar",
			"You know, he's a sweet old man.",
			"Pretty simple math, huh, Bob?",
			"You better pray that that unholy monster of yours doesn't screw up. ",
			"They'll fix you. They fix everything.",
			"Looking for me?",
			"I know you! You're dead! We killed you!",
			"You better watch your back, Bob.",
			"Jones is gonna come looking for you.",
			"Too bad about Kinney, huh?",
			"He fumbled the ball, I was there to pick it up.",
			"Soon as some poor schmuck volunteers.",
			"Excuse me, I have to go. Somewhere there is a crime happening.",
			"Let me make something clear to you. He doesn't have a name. He has a program. He's product.",
			"Bitches, leave!",
			"See, I got this problem. Cops don't like me. So I don't like cops.",
			"Okay Miller! Don't hurt the mayor! We'll give you what you want!",
			"Nobody ever takes me seriously! We'll get serious now... and kiss the mayor's ass goodbye!",
			"Nice shooting, son. What's your name?",
			"Forget it, kid. This guy's a serious asshole.",
			"Your client's a scumbag, you're a scumbag, and scumbags see the judge on Monday morning. Now get out of my office, and take laughing boy with you!",
			"Murphy, it's you!",
			"Please put down your weapon. You have 20 seconds to comply.",
			"Four... three... two... one... I am now authorized to use physical force!",
			"Thank you for your cooperation. Good night.",
			"Book him! What's the charge? He's a cop killer.",
			"Dick, you're *fired*!",
			"Well guys, the other one was upstairs. She was sweeeeet, mmph-mmm-mmm. I took her out, Ha-ha-ha-ha-ha-ha...",
			"You probably don't think I'm a very nice guy... do ya? ",
			"I had a guaranteed military sale with ED209! Renovation program! Spare parts for 25 years! Who cares if it worked or not!",
			"First, don't mess with me. I'm a desperate man! And second, I want some fresh coffee. And third, I want a recount! And no matter how it turns out, I want my old job back!",
			"I'm cashing you out, Bob.",
			"Oooh. Guns, guns, guns. C'mon, Sal. The Tigers are playing...",
			"Frankie, blow this cocksucker's head off.",
			"You call this a GLITCH?",
			"I work for Dick Jones! Dick Jones! He's the Number Two Guy at OCP. OCP runs the cops.",
			"Don't mess with Jones, man. He'll make sushi out of you.",
			"Good night, sweet prince.",
			"Nukem. Get them before they get you. Another quality home game from Butler Brothers.",
			"Old Detroit has a cancer. That cancer is crime.",
			"What? I thought we agreed on total body prosthesis, now lose the arm okay!",
			"Shut him down, prep him for surgery.",
			"Hey, he's old, we're young, and that's life.",
			"Hey, dickey boy, how's tricks? ",
			"That's two million workers living in trailers, that means drugs, gambling, prostitution...",
			"We practically are the military.",
			"Here at Security Concepts, we're predicting the end of crime in Old Detroit within 40 days. There's a new guy in town. His name is RoboCop.",
			"Does it hurt? Does it hurt?",
			"Are you a college boy?",
			"The Star Wars Space Peace Platform",
			"That's life in the big city",
			"Hey there buddy boy",
			"Good business is where you find it",
			"Oh Dick, I'm very disappointed",
			"Stay out of trouble",
			"Your move creep",
			"Dead or alive, you're coming with me",
			"And remember, we care",
			"Madame, you have suffered an emotional shock. I will notify a rape crisis center.",
			"You mind if I, zip this up?",
			"You gonna be a bad motherfucker!",
			"I used to call the old man funny names. Iron Butt. Boner. Once I even called him...asshole.",
			"I always knew where the line was drawn. And you just stepped over it, buddy-boy.",
			"You've insulted me. And you've insulted this company with that bastard creation of yours.",
			"The old man thought it was pretty important, Dick.",
			"I had to kill Bob Morton because he made a mistake. Now it's time to erase that mistake.",
			"I'm not arresting you anymore.",
			"Robo, any special message for all the kids watching at home?",
			"Something with reclining leather seats, that goes really fast, and gets really shitty gas mileage! Alright.",
			"Lieutenant, don't jerk me off! When people jerk me off, I kill them! You wanna see?",
			"Serve the public trust, protect the innocent, uphold the law.",
			"It's back! Big is back, because bigger is better than ever! 6000 SUX: An American Tradition!",
			"I think you better do as he says, Mr. Kinney.",
			"Are you a good cop, hotshot? Why, sure you are! you gotta be some kind of GREAT cop, coming in here all by yourself. Where's your partner?",
			"I'll bet that really pisses you off.",
			"Buddy, I think you're slime ",
			"Hey Emil! How's the Gray Bar Motel? They let me keep the shirt. Nobody popped my cherry!",
			"Cobra Assault Cannon, state of the art, bang bang! ",
			"You listen to me, you asshole! You're talking about shutting down a major metropolitan police force! Without cops, this city would tear itself apart!",
			"Make it aggravated assault and I can make bail in cash, now.",
			"I can feel them... but I can't remember them.",
			"You're our product. And we can't very well have our products turning against us, can we?",
			"Your ass is mine!",
			"Just give me my fucking phone call. ",
			"Hello, buddy boy. Dick Jones here.",
			"I guess you're on your knees right about now. Begging for your life. Pathetic.",
			"You don't feel so cocky now do ya Bob?",
			"You know what the tragedy here is, Bob? We could have been friends.",
			"But life goes on, it's an old story, the fight for love and glory, huh Bob?",
			"I got the muscle to shove enough of this factory so far up your stupid wop ass that you'll shit snow for a year.",
			"Just kidding.",
			"Somebody wanna call a goddamn paramedic?",
			"Yeah, you better be careful. I hear Jones is a real shark.",
			"Pakistan is threatening my border! That's it, buster! No more military aid.",
			"Tastes like baby food!",
			"Doesn't matter, we're gonna blank his memory anyway.",
			"Think about it, chum. Good business is where you find it.",
			"Jesus, you really screwed up.",
			"It's a free society. Except there ain't nothing free, because there's no guarantees. You know? You're on your own. That's the law of the jungle.",
			"Maybe what we need here is a fresh perspective. ",
			"My friends. I've had this dream for more than a decade now.",
			"I had to blow the door! What do you want?",
			"Terrorism is a very tricky business. Massive and immediate retaliatioin is the best policy.",
			"Okay, fun's over.",
			"Now move! Open the safe pops. Open the god damn safe!",
			"There's a new guy in town. His name is RoboCop.",
			"Fuck me! Fuck me! Fuck me! Fuck me! Fuck me! Fuck me! Fuck me!", };

	public static String GetRandomQuote()
	{
		int index = _Quotes.length;
		Random rand = new Random();
		index = rand.nextInt(index);
		return _Quotes[index];
	}

}
