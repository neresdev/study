# ***`Commands`***

- Where is this?
    
    ```bash
    #Java:
    cd /lib/jvm/
    # and 
    /usr/lib/jvm
    ##################
    ```
    
- Main Commands
    - For *Control + F* in a file usage less command, example:
        
        ```bash
        less <file>
        ```
        
        when the window is open, type “/<word to find>”
        
    - For change java version
        
        ```bash
        #On ubuntu
        	sudo update-alternatives --config java
        #On manjaro
        sudo archlinux-java set
        ```
        
        Website for help: https://dzone.com/articles/installing-oracle-java6-ubuntu / https://docs.datastax.com/en/jdk-install/doc/jdk-install/installOpenJdkDeb.html
        
- For run 2 commands
    
    ```bash
    ls homeDirectory || echo "I will be best programmer on visualmix"
    ```
    
- For run 2 commands only previous one returns success
    
    ```bash
    ls homeDirectory && cat textFile.txt
    ```
    
- If command backs or forward one folder run like this
    
    ```bash
    cd .. ; ls # vai voltar uma pasta no shell atual
    ( cd .. ; ls ) # será criado um "subshell" e não voltará uma pasta no terminal atual  
    
    ```
    
- For save the returns of all command
    
    ```bash
    #if returns success
    ls  > out.log
    
    #if returns error
    ls 2> outerr.log
    
    #for replace content in log
    ls > out.log
    
    #for add content in log
    ls >> out.log
    #in error case
    ls 2>> outerr.log
    
    ##################### BEST USAGE #####################
    ls directory_for_list >> log.out 2>> logerr.out 
    # for save success return and error return in same file
    ls directory_for_list >> log.out 2>> log.out
    
    ################## TRASH OF LINUX ##################
    ls -l sdaasdasdsad 2> /dev/null
    #NOTE: this command put the hide error message if the command returns error
    ```
    
- Variables in shell
    
    ```bash
    NAME_VARIABLE=ANY_THING
    echo $NAME_VARIABLE # returns ANY_THING
    ```
    
- Customizing shell
    
    Website: https://medium.com/@satriajanaka09/setup-zsh-oh-my-zsh-powerlevel10k-on-ubuntu-20-04-c4a4052508fd 
    
- When error “**[Error mounting](https://askubuntu.com/questions/586308/error-mounting-dev-sdb1-at-media-on-ubuntu-14-04-lts) <path to storage>**”
    
    ```bash
    # sudo ntfsfix <path> // example:
    sudo ntfsfix /dev/sda2
    ```
    
- find command
    
    ```bash
    #find <pasta> -name <nomearquivo>
    find . -name text_file.txt
    
    #find <pasta> -iname <nomearquivo>
    find . -iname text_file.txt
    #busca ignorando a caixa alta
    
    ```
    
- wc command
    
    ```bash
    #nesse caso, irá mostrar quantas linhas o comando "ls -l" retornou
    ls -l . | wc -l
    ```
    
- ps command
    
    ```bash
    #ps da um rápido reporte aos processos em execução no sistema
    #adicione a flag -e para visualizar todos os processos, semelhante ao comando top
    ps
    ```
    
- find java command
    
    ```bash
    readlink -f $(which java)
    ```
    
- xclip command example
    
    ```bash
    ####
    echo "teste" | xclip -selection c
    ```
    
- Difference between File Globing and Regex
    
    File globbing’s main objective is to search for files using similar characters to those used in reges. However, regex is used to search for text rather than files.
    
- File Globbing
    - Brackets usage
        
        ```bash
        # when
        ls
        # then return
        file1 file2 file3 File4
        
        #when 
        ls file[13]
        #then return
        file1 file3
        
        #when
        ls file[1-3]
        #then return
        file1 file2 file3
        
        #when
        ls [Ff]ile[1-2]
        #then return
        file1 file2 file3 File4
        
        ```
        
- regular expressions
- 

# ***`Vi editor`***

link for help

[Vi Cheat Sheet / Linux Terminal Cheat Sheet (PDF) - Smashing Magazine](https://www.smashingmagazine.com/2010/05/vi-editor-linux-terminal-cheat-sheet-pdf/)