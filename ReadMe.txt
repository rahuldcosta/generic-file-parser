Steps to Run Application
1. Navigate to generic-file-parser\target
2. Open CMD/GIT Bash/PowerShell in this folder
3. Type command java -jar GenericFileParserMainApplication.jar file=foo.zzz path=\Data encoding=UTF8 compression=gzip encryption=AES128
		Please refer to below example
		[EXAMPLE]:- java -jar GenericFileParserMainApplication.jar file=foo.zzz path=\Data encoding=UTF8 compression=gzip encryption=AES128
		[NOTE] :- File name and path is mandatory
		Supported encoding format:-     [UTF-8,ISO-8859-1]
		Supported Compression format:-  [bzip,zip,bz,gzip]
		Supported Encryption format:-   [AES128,AES256,RSA]
4. Hit Enter and your results will be displayed on the screen.

To compile Source code
1. Navigate to generic-file-parser folder 
2. Type mvn clean compile assembly:single
3. Hit Enter
4. Your new jar will be created in target folder

To Run all the test cases
1. Load Project In IDE(Intelij/Eclipse)
2. Add command line arguments in Run configuration
2. Execute GenericFileParserMainApplication