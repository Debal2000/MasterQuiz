
    function displayRadioValue() { 
        document.getElementById("result").innerHTML = ""; 
        var ele = document.getElementsByTagName('input'); 
        var ans=['B','D','C','A','A','B','B','A','C','D'];
        var q=['Q1','Q2','Q3','Q4','Q5','Q6','Q7','Q8','Q9','Q10'];
        var k=['0','0','0','0','0','0','0','0','0','0'];
        var j=0;
        var x=['0','0','0','0','0','0','0','0','0','0'];
        document.getElementById("result").innerHTML 
            +="Your Ans:<br>";
        for(i = 0; i < ele.length; i++) { 
              
            if(ele[i].type="radio") { 
              
                if(ele[i].checked) {document.getElementById("result").innerHTML 
                +="Option: " 
                + ele[i].value + "<br>";
            k[j]=ele[i].name;
            x[j]=ele[i].value;
            j++ }
                    
            } 
        }
        document.getElementById("result").innerHTML 
        +="Correct Ans:<br>";
       var score=0,tota1=0;
       var y=0;
       for(i=0;i<10;i++)
       {
           for(j=0;j<10;j++)
           {
               if(k[j]==q[i])
               {
                   if(ans[j]==x[j])
                   score=score+1;
               }
           }
       }
       for(i=0;i<10;i++)
       {
        document.getElementById("result").innerHTML 
        +=(i+1)+")Option: "+ans[i]+"<br>";
       }
       document.getElementById("result").innerHTML 
        +="SCORE:<br>"+score+"/10";
        if(score<=5)
        alert("No need to get demotivated\n"+score+"/10")
        else if(score<=9)
        alert("there is scope of improvement\n"+score+"/10")
        else
        alert("good job\n"+score+"/10")
    } 