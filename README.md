# README #

Start off by running ```git clone https://github.com/rudotriton/fse-coursework-unit-testing.git``` in your git bash shell or in whatever else you are used to using.

After this run ```git checkout development``` which takes you to the development branch.
 All of the changes should be merged into this branch and from this, into the master 
 branch later on.

Next run ```git checkout -b your-branch-name-here```. Make all of your work on this branch 
and once you are done and have committed all of the changes run ```git checkout development``` 
and ```git merge your-branch-name-here``` to merge the changes that you have made, into
 the **development** branch. If you get some merge conflicts then solve them and try to merge again.

After this, while you're still on the **development** branch, run ```git push``` and your changes 
should be pushed to **origin**. This isn't always possible as the **origin** may have some 
changes that are not on your local **development** branch. To get around this run ```git pull``` 
to fetch the latest changes. Sometimes you need to resolve a conflict here. If you are done with 
the conflict resolution then run ```git commit``` to commit the changes and run ```git push``` 
to finish pushing your changes to the **origin**.

Your bash shell should indicate which branch you have currently checked out and after you have pushed the changes while being on the **development** branch your branch is still there which means that if you wish to make more changes to the code then simply run ```git checkout your-branch-name-here``` and you are back on your branch.

If all goes well then on Friday we have to do only some simple fixes, merge **development** into **master** and we should be done.

#### Recap ####

1. ```git clone https://github.com/rudotriton/fse-coursework-unit-testing.git```

2. ```git checkout development```

3. ```git checkout -b your-branch-name-here```

After you are done working and have committed your work to your branch:

4. ```git checkout development```

5. ```git merge your-branch-name-here```

6. ```git push```

```Git push``` has to sometimes be preceded by ```git pull``` followed by solving a conflict
 and running ```git merge```. After this running ```git push``` should work without any
  further conflicts.



### Useful commands ###

For prettier and super informative ```git log``` command run the following command in your bash shell. After this every time you run **git lgb** (you can replace the alias **lgb** in the command if you wish to use some other shortcut) on your command line, you get an overview of all the branches and commits along with some other useful information. This can help you picture what is actually going on behind the scenes.

```git config --global alias.lgb "log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset%n' --abbrev-commit --date=relative --branches"```
