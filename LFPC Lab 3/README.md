#How to use
The script must be called in a form like ``CFG2CNF.py model.txt``, and it produces an ``out.txt`` file.
The Grammar G=(V, T, P, S) is read by a `.txt` file, so need a certain formattation, that follow:
```
Terminals:
+ - ( ) ^ number variable
Variables:
Expr Term AddOp MulOp Factor Primary
Productions:
Expr -> Term | Expr AddOp Term | AddOp Term;
Term -> Factor | Term MulOp Factor;
Factor -> Primary | Factor ^ Primary;
Primary -> number | variable;
Primary -> ( Expr );
AddOp -> + | -;
MulOp -> * | /
```
Is important to:
* Use spaces between symbols, one space, not more
* use te ';' character to separate rows in productions: don't use for the last.

Variant 13 is already written in ``model.txt`` file.

#The Routine
The routine follows [Wikipedia](https://en.wikipedia.org/wiki/Chomsky_normal_form) formulation of this algorthm, in particular:
1. **START**: add ``S0->S`` production
2. **TERM**: replace terminal symbols with variables in production containing boht on the right
3. **BIN**: make rules binaries, in other words break in more parts rules which right side is longer than 2
4. **DEL**: eliminate ε-rules and eventually rearrange other productions
5. **UNIT**: remove all production which the right side is only a variable

