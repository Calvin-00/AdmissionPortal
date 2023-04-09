const form = document.getElementById('form');
const usernameLogin = document.getElementById('usernameLogins');
const passwordLogin = document.getElementById('passwordLogins');

form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
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

const validateInputs = () => {
    const usernameLoginValue = usernameLogin.value.trim();
    const passwordLoginValue = passwordLogin.value.trim();

    
    
    if(usernameLoginValue === '') {
        setError(usernameLogin, 'Username field is empty');
    } else if (usernameLoginValue !== 'auca') {
        setError(usernameLogin, "Incorrect Username");
    } else {
        setSuccess(usernameLogin);
    }
    
    if(passwordLoginValue === '') {
        setError(passwordLogin, 'Password field empty');
    } else if (passwordLoginValue !== 'auca') {
        setError(passwordLogin, "Incorrect Password");
    } else {
        setSuccess(passwordLogin);
    }

};


