# What does the fox truly say? 

## Prelude

Determined to discover the ancient mystery — the sound that the fox makes — you went into the forest, armed with a very good digital audio recorder. The forest is, however, full of animals’ voices, and on your recording, many different sounds can be heard. But you are well prepared for your task: you know exactly all the sounds which other animals make. Therefore the rest of the recording — all the unidentified noises — must have been made by the fox.

## Input
- The first line of input contains the number of recordings. Every recording is written on a new line. Also, every recording represents a list of lowercase English words, separated by spaces.
- The next few lines are your pre-gathered information about other animals, in the format &lt;animal&gt; goes &lt;sound&gt; (see the example below). Their names are actual names of animals in English. There is no "fox goes ..." among these lines.
- The last line of the input is exactly the question you are supposed to answer: what does the fox say?

## Output

Delete all known sounds from the recordings and output the resulted lines, containing the sounds made by the fox, in the order from the recordings. You may assume that the fox was not silent (contrary to popular belief, foxes do not communicate by Morse code).

### Example input
```
2
toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
dog goes woof
fish goes blub
elephant goes toot
seal goes ow
what does the fox say?

```

### Example output

Note that there are no spaces at the end of each line in the output. 
```
wa pa pa pa pa pa pow
wa pa pa pa pa pa pow

```
## Your assignment

- Create `Fox.java` file in this repository. Make sure it is exactly `Fox.java`, otherwise, the automatic tests will fail.
- Create `README.md` file where you will add information about your program: what it does and who cares about it.
- IMPORTANT: document your code! That includes but not limited to: writing comments about what every function does, writing comments for blocks of your code (like loops and if statements), writing comments about what the program does and who is the author. It is going to be 10% of your grade in the future.
- For this program, if you miss an area where it feels like a comment is needed because of its complexities, I will show you how it would look like in Java doc so don't freak out about comments just yet, I understand that it was not a requirement in previous classes.
- Write a program that, given the input, would produce the answer to an ancient question, "what does the fox say?"
- NOTE: the first number defines how many lines of text follow with the sounds.
- After writing the program and testing it on the above-mentioned Example, figure out whom the fox quotes in the following input. Put the answer in the comments somewhere in your code.
- Your submission would be done via GitHub Classrooms in this repository. Feel free to continue using `Codespaces`, or you can connect it to your `VS Code` on your laptop.

```
3
toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
toot da wa ow rn ow blub blub it wa toot ow blub man pa ow pow toot toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
toot woof wa ow ow ow ov blub blub va toot ti blub ka ti ow pow toot ma pow ti the ow ow wa blub be toot woof ow wa st wa woof ide wa blub blub woof wa as co wa wa toot me as jo wa woof wa ow kes ma ow toot ke yo wa toot wa ur thin toot woof wa wa ow wa ow king as woof wa wa woof fu woof woof wa wa ow wa nny as po ow wa ow ssi woof toot ble da toot woof vid ogi wa wa ow lvy
dog goes woof
fish goes blub
elephant goes toot
seal goes ow
cat goes wa
student goes sleep
teacher goes nuts
russian goes hack
i go eat
what does the fox say?

```
