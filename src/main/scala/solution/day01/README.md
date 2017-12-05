--- advent_of_code.Day 1: Inverse Captcha ---

The night before Christmas, one of Santa's Elves calls you in a panic. "The printer's broken! We can't print the Naughty or Nice List!" By the time you make it to sub-basement 17, there are only a few minutes until midnight. "We have a big problem," she says; "there must be almost fifty bugs in this system, but nothing else can print The List. Stand in this square, quick! There's no time to explain; if you can convince them to pay you in stars, you'll be able to--" She pulls a lever and the world goes blurry.

When your eyes can focus again, everything seems a lot more pixelated than before. She must have sent you inside the computer! You check the system clock: 25 milliseconds until midnight. With that much time, you should be able to collect all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day millisecond in the advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You're standing in a room with "digitization quarantine" written in LEDs along one wall. The only door is locked, but it includes a small interface. "Restricted Area - Strictly No Digitized Users Allowed."

It goes on to explain that you may only leave by solving a captcha to prove you're not a human. Apparently, you only get one millisecond to solve the captcha: too fast for a normal human, but it feels like hours to you.

The captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.

For example:

 - 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
 - 1111 produces 4 because each digit (all 1) matches the next.
 - 1234 produces 0 because no digit matches the next.
 - 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

What is the solution to your captcha?

--- Part Two ---

You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:

Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.

For example:

 - 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
 - 1221 produces 0, because every comparison is between a 1 and a 2.
 - 123425 produces 4, because both 2s match each other, but no other digit has a match.
 - 123123 produces 12.
 - 12131415 produces 4.

What is the solution to your new captcha?

--- Input ---

68376334795224855827459835293967497295464175589881588256882344
69947359541391268827864723586256612323398392166257879291745391
27953527464265126499656159195885121255671868374113711798752876
21488759761429629174886972298349197722423458299323141529413191
32762248524949586416818132719766145446492632624827499944837374
18399631556468288427527612931423564229643553495219874832114963
61289666375779728345952231649453711684539164893151811849653331
84599899859799114688136171723451791175989379234881581875526245
63786271167794954355961396172465716785311833359562441638714456
74244765586446362529159854137535962117184875192273872222899887
35729231297828618263623292125257473811834752118763782962383187
24373819792239556756342578891378236849241273384332485195152117
96732599314921611399736571277222546332369461136277417419794865
52412398972249235653683231393759743771787378759384946883673364
25293785471511463975329972374393876637693347229791729548351544
86382983716698212694357398153392926255272961384626131829678171
21956928868559714113235532278825416392388837815557394875318542
31589978777186876424464574466434225365412389797617254964262923
59382168535641216124211741896552562128941824172241913873537828
97617273827698391523224145158942191112156722889985393466795478
62562236146215546182944671912551533952565247861597584296437565
86457639177183891162214163549688595416893383194995824534247841
41424752626821276195491371945211487676474579998279259475375962
63343196311919178943681167388935487976611118996641383983548189
31135486984944719992393148681724116616741428937687985152658296
67984547476647774155363271296867917535645298745976112643721675
81711823952193932891991489968137628499914846784297935786293312
15796996751484375784895561682156658579887518746862371751372692
47276521737479132465674529157478449529947736296467635114818367
68971223668386563427459449452752636177293598314665656949832172
52594237828187612857523344265418227883219383138893873384775659
54863766286757268719826368859786511817392161517816544213398736
2382721444844952715592955744739873677838847693982379696776
