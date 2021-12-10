/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 function checkBox(obj){
                var flag=confirm("Do you want to delete?")
                if(flag==true){
                        alert("It will mark for deletion. Data will be deleted only when you click on the Save button");
                    }}
 function charCount()
            {
                 var cval=document.getElementById("foComment").value;
                 var ss=document.getElementById("foComment").value.length;
                 if(cval.length>1999){
                 document.getElementById("foComment").value=cval.substring(0, 2000);
             }
                 document.getElementById("countDWord").innerHTML=2000-ss+"  characters left";
            }
function charCountsko()
            {
                 var cval=document.getElementById("foCommentL2").value;
                 var ss=document.getElementById("foCommentL2").value.length;
                 if(cval.length>1999){
                 document.getElementById("foCommentL2").value=cval.substring(0, 2000);
             }
                 document.getElementById("countDWord").innerHTML=2000-ss+"  characters left";
            }
function charCountL2()
            {
                 var cval=document.getElementById("foCommentL2").value;
                 if(cval.length>1999){
                 document.getElementById("foCommentL2").value=cval.substring(0, 2000);
                 }
                 var ss=document.getElementById("foCommentL2").value.length;
                 document.getElementById("countDWordL2").innerHTML=2000-ss+"  characters left";
            }
function charCountL3()
            {
                 var cval=document.getElementById("foCommentL3").value;
                 if(cval.length>1999){
                 document.getElementById("foCommentL3").value=cval.substring(0, 2000);
                 }
                 var ss=document.getElementById("foCommentL3").value.length;
                 document.getElementById("countDWordL3").innerHTML=2000-ss+"  characters left";
            }            
function charCount1000()
            {
                var cval=document.getElementById("foComment").value;
                 if(cval.length>999){
                 document.getElementById("foComment").value=cval.substring(0, 1000);
                 }
                 var ss=document.getElementById("foComment").value.length;
                 document.getElementById("countDWord").innerHTML=1000-ss+"  characters left";
                 
            }
function charCount2000()
            {
                var cval=document.getElementById("foComment").value;
                 if(cval.length>1999){
                 document.getElementById("foComment").value=cval.substring(0, 2000);
                 }
                 var ss=document.getElementById("foComment").value.length;
                 document.getElementById("countDWord").innerHTML=2000-ss+"  characters left";
                 
            }            
  function exitWin()
            {
                
            $("#test>#loader").css("display","block");
            $("#test").empty();
            $("#test").load("./AnnualReturn/pendingAR/F_finYear.jsp", {}, function() {
                $("#test>#loader").css("display","none");
             });
             
            }
 function exitWinsko()
            {
                
            $("#testSKO>#loader").css("display","block");
            $("#testSKO").empty();
            $("#testSKO").load("./AnnualReturnSKO/pendingARSKO/F_finYear_sko.jsp", {}, function() {
                $("#testSKO>#loader").css("display","none");
             });
             
            }
function exitWinEs()
            {
                $("#testEs>#loader").css("display","block");
                $('#testEs').empty();
                $("#testEs").load("./AnnualReturn/escalatedAR/F_finYearEs.jsp", {}, function() {
                $("#testEs>#loader").css("display","none");
                });
            }       
function exitWinEssko()
            {
                $("#testEsSKO>#loader").css("display","block");
                $('#testEsSKO').empty();
                $("#testEsSKO").load("./AnnualReturnSKO/escalatedARSKO/F_finYearEs_sko.jsp", {}, function() {
                $("#testEsSKO>#loader").css("display","none");
                });
            }       
function ValidatePAN(Obj) 
{
        if (Obj.value != "") 
        {
            ObjVal = Obj.value;
             var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
             if (ObjVal.search(panPat) == -1) {
             alert("Invalid Pan No");
             Obj.value="";
             Obj.focus();
             return false;
             }else{
                  
              }
        }
        else
        {
        alert("Enter PAN");    
        Obj.value="";
        Obj.focus();
        return false;
        }
        return true;
}
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 function addInputBox() 
                 {
                    var inputDiv = document.getElementById('myDiv');
                    var numi =document.getElementById("inputboxid");
                    var num = parseInt(numi.value) +1;
                    numi.value = num;      
                    var newdiv = document.createElement('div');
                    var divIdName = 'my'+num+'Div';
                    newdiv.setAttribute('id',divIdName);
                    newdiv.innerHTML = "<select name=\"select"+num +"\"><option>Mr.</option><option>Mrs.</option><option>Ms.</option></select><input type=\"text\" size='30' name=\"txtArea"+num +"\"/>\n";
                    inputDiv.appendChild(newdiv);
                  }
function addInputBox1() 
                 {
                    var inputDiv = document.getElementById('myDiv');
                    var numi =document.getElementById("inputboxid");
                    var num = parseInt(numi.value) +1;
                    numi.value = num;      
                    var newdiv = document.createElement('div');
                    var divIdName = 'my'+num+'Div';
                    newdiv.setAttribute('id',divIdName);
                    newdiv.innerHTML = "<select name=\"select"+num +"\"><option>Mr.</option><option>Mrs.</option><option>Ms.</option><option>M/s</option></select><input type=\"text\" size='30' name=\"txtArea"+num +"\"/>\n";
                    inputDiv.appendChild(newdiv);
                  }

function removeInputBox() {
                    
                var d = document.getElementById('myDiv');
                var numi = document.getElementById("inputboxid");
                if(numi.value>0){
                var temp = "my"+numi.value+"Div";
                var num = parseInt(numi.value) -1;
                numi.value = num;
                var olddiv = document.getElementById(temp);
                d.removeChild(olddiv);
                }else{alert("No rows to delete");}
                }
 function showHide()
 {
               document.getElementById("newFile").style.display="block";
               document.getElementById("oldFile").style.display="none";
 }
function validationDA(thisform)
{

 var rcda=document.getElementById("daFile_id");

   if(rcda.value==""){
        alert("Select file to upload");
           return false;
       }
       
       else{

            c=rcda.value;
            var field_format=c.substring(c.lastIndexOf(".")+1).toLowerCase();
            if(field_format!="pdf"&&field_format!="jpeg"&&field_format!="jpg")
            {
                alert ( "Please Select Correct File Format(.pdf, .jpeg or .jpg) to Upload");
                rcda.form.reset();
                rcda.focus();
                //r.value="";
                return false;
            }
      }


      return true;
}      
