- List all commits in a nutshell with `git log --oneline`
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fc3e490f-c292-425d-aa3a-c637bbf8b77c/Untitled.png)
    
- Reset files
    
    ```bash
    # for a one file
    git checkout -- file_name.txt
    
    # for all files
    git checkout -- .
    ```
    
- **(Only for changed files)** Remove file from stage (after run `git add <file name>` or `git add .`)
    
    ```bash
    # for one file
    git checkout HEAD -- <file_name> 
    
    # for all files
    git checkout HEAD -- .
    ```
    
- Create an commit reversing previous commit
    
    ```bash
    git revert <commit hash>
    ```
    
- Reset a project to commit **(Use only if commit isnt pushed, if it is pushed, use `git revert`)**
    
    ```bash
    # Returns 1 commit
    git reset HEAD~1 
    ```
    
- Conflits
    
    ```bash
    console.log('arquivo para ser o conflito'); 
    <<<<<<< HEAD
    Adadsada # change in my local repository
    =======
    console.log('nova linha'); # change in remote repository
    >>>>>>> b20667a0e650295d8b2690d541b8c7fa6d0bc032
    ```
    
    for solve it, just delete `<<<<<<< HEAD` and `>>>>>>> b20667a0e650295d8b2690d541b8c7fa6d0bc032` and it will works!
    
- Branches
    
    ```bash
    # for create 
    git branch <branch_name>
    
    # for delete
    git branch -d <branch_name>
    
    # for change current branch
    git checkout <branch_name>
    ```