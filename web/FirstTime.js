
function validate(){
    var isemailValid1=true;
    var ispasswordValid1=true;
    var ispasswordValid2=true;

    if(document.getElementById("firstEmail").value===""){
        isemailValid1=false;
        document.getElementById("emailError").innerHTML="Please Enter Email";
        document.getElementById("emailError").style.color="red";
    }else if(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(document.getElementById("firstEmail").value)===false){
        isemailValid1=false;
        document.getElementById("emailError").innerHTML==="Please Enter valid Email. Its must contain @charactor";
        document.getElementById("emailError").style.color="red";
    }else{
        isemailValid1=true;
        document.getElementById("emailError").innerHTML="";
       
    }

    if(document.getElementById("firstPassword").value===""){
        ispasswordValid1=false;
        document.getElementById("passError").innerHTML="Please Enter your password";
        document.getElementById("passError").style.color="red";
    }else if(document.getElementById("firstPassword").value.length <8){
        ispasswordValid1=false;
        document.getElementById("passError").innerHTML="Invalid password it must have at least 8charactors";
        document.getElementById("passError").style.color="red";

    }else{
        ispasswordValid1=true;
        document.getElementById("passError").innerHTML="";
       
    }
    
    if(document.getElementById("firstPasswordAgain").value==="") {
        ispasswordValid2=false;
        document.getElementById("passError").innerHTML="Please confirm your password";
        document.getElementById("passError").style.color="red";
    } else if (document.getElementById("firstPasswordAgain").value!==document.getElementById("firstPassword").value) {
       
        ispasswordValid2=false;
        document.getElementById("passError").innerHTML="Passwords doesn't match";
        document.getElementById("passError").style.color="red";
    } else {
        ispasswordValid2=true;
        document.getElementById("passError").innerHTML="";
    }

    if(isemailValid1===false||ispasswordValid1===false||ispasswordValid2===false){
        return false;
    }else{
        return true;
    }

}

