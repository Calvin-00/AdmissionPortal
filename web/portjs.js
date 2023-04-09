const form = document.getElementById('form');
const firstname = document.getElementById('firstName');
const lastname = document.getElementById('lastName');
const parent = document.getElementById('parentName');
const email = document.getElementById('email');
const phonenumber = document.getElementById('phoneNumber');
const faculty = document.getElementById('faculty');
const department = document.getElementById('department');
const emergencyNum = document.getElementById('parentNum');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');

form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
//    if(validateInputs()){ 
//      //return true;
//      
//       e.preventDefault();
//
//    validateInputs();
//      
//   
//  //alert("Registered Successful!!"); 
//    
//}     
//   else {
//          
//    alert("Please fix the errors before submitting the form.");
////    return false;
//  }
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
};

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

const validLettersf = firstname => {
    const check = /^[a-zA-Z]+$/;
    return check.test(firstname);
};
const validLetterslast = lastname => {
    const check = /^[a-zA-Z]+$/;
    return check.test(lastname);
};
const validLettersp = parent => {
    const check = /^[a-zA-Z]+$/;
    return check.test(parent);
};
const validLettersfty = faculty => {
    const check = /^[a-zA-Z]+$/;
    return check.test(faculty);
};
const validLettersdpt = department => {
    const check = /^[a-zA-Z]+$/;
    return check.test(department);
};

const validateInputs = () => {
    const firstnameValue = firstname.value.trim();
    const lastnameValue = lastname.value.trim();
    const parentValue = parent.value.trim();
    const emailValue = email.value.trim();
    const phonenumberValue = phonenumber.value.trim();
    const facultyValue = faculty.value.trim();
    const departmentValue = department.value.trim();
    const emergencyNumValue = emergencyNum.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();

    if(firstnameValue === '') {
        setError(firstname, 'Empty field, First name is required');
    } else if (!validLettersf(firstnameValue)) {
        setError(firstname, 'Enter only letters');
    } else {
        setSuccess(firstname);
    }
    
    if(lastnameValue === '') {
        setError(lastname, 'Empty field, Last name is required');
    } 
//    else if (!validLetterslast(lastnameValue)) {
//        setError(lastname, 'Enter only letters');
//    } 
    else {
        setSuccess(lastname);
    }
    
    if(parentValue === '') {
        setError(parent, 'Parent/Guardian name is required');
    } else if (!validLettersp(parentValue)) {
        setError(parent, 'Enter only letters');
    }else {
        setSuccess(parent);
    }

    if(emailValue === '') {
        setError(email, 'Email is required');
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Provide a valid email address');
    } else {
        setSuccess(email);
    }
    
    if(phonenumberValue === '') {
        setError(phonenumber, 'Phone number is required');
    }else if (phonenumberValue.length < 10 ) {
        setError(phonenumber, 'Phone number is less than 10 digits.');
    }else if (phonenumberValue.length > 10 ) {
        setError(phonenumber, 'Phone number is greater than 10 digits.');
    } else {
        setSuccess(phonenumber);
    }
    
    if(facultyValue === '') {
        setError(faculty, 'Empty field, Faculty is required');
    } else if (!validLettersfty(facultyValue)) {
        setError(faculty, 'Enter only letters');
    } else {
        setSuccess(faculty);
    }
    
    if(departmentValue === '') {
        setError(department, 'Empty field, Department is required');
    } else if (!validLettersdpt(departmentValue)) {
        setError(department, 'Enter only letters');
    } else {
        setSuccess(department);
    }
    
    if(emergencyNumValue === '') {
        setError(emergencyNum, 'Parent/Guardian phone number is required');
    } else {
        setSuccess(emergencyNum);
    }

    if(passwordValue === '') {
        setError(password, 'Password is required');
    } else if (passwordValue.length < 8 ) {
        setError(password, 'Password must be at least 8 character.');
    } else {
        setSuccess(password);
    }

    if(password2Value === '') {
        setError(password2, 'Please confirm your password');
    } else if (password2Value !== passwordValue) {
        setError(password2, "Passwords doesn't match");
    } else {
        setSuccess(password2);
    }

    
};
