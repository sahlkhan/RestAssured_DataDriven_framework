1] Feature of my project
   i)This project is capable to automate execution and validation:
       >Rest:Post,put,patch,delete and get
       >Soap:Post,Get

   ii)Constructed the request body using parameters taken from an excelfile,i have created an Common utility using ApachePoi to read data from excelsheet.

   iii)Project is constructed on the  theory of data driven and keyword driven
         .I dived the projects into four parts and make four package
            1>Request Repositry=I have encapsulated BaseURI,Requestbody,Resource.
            2>Common Method= I have fetched the statuscode and Responsebody in common method.
            3>Test Class=I have extracted statuscode and responsebody and we parse the response and validate    
              responsebody parameter
            4>Driver Class= I have created driver classes to execute the testclasses in a sequence
   iv)The test execution is driven by Static driver class
    v)Project is capable to save evidence of the execution inside text files which contain details of       request sent,endpoint and response received.
