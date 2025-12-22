function validateName() {
    let i = document.getElementById("staff_name"), e = document.getElementById("nameerr");
    if (i.value.trim() === "" || !/^[A-Za-z\s]+$/.test(i.value)) {
        e.innerText = "please enter valid name";
        return false
    }
    e.innerText = "";
    return true
}

function validateEmail() {
    let i = document.getElementById("email"), e = document.getElementById("emailerr");
    if (!/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/.test(i.value)) {
        e.innerText = "please enter valid email";
        return false
    }
    e.innerText = "";
    return true
}

function validatePassword() {
    const password=document.getElementById("password");
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    const e = document.getElementById("passworderr");
     if(!regex.test(password.value)){
         e.innerText="password must contain 8+ chars, at least 1 uppercase, 1 lowercase, 1 number"
         return false
     }
    e.innerText = "";
    return true
}
function validatePhone() {
    let i = document.getElementById("phone"), e = document.getElementById("phonerr");
    if (!/^[0-9]{10}$/.test(i.value)) {
        e.innerText = "please enter valid phone number";
        return false
    }
    e.innerText = "";
    return true
}

function validateGender() {
    let e = document.getElementById("gendererr");
    if (!document.querySelector('input[name="Gender"]:checked')) {
        e.innerText = "Select gender";
        return false
    }
    e.innerText = "";
    return true
}

function validateSelect(id, err, msg) {
    let v = document.getElementById(id).value, e = document.getElementById(err);
    if (v === "") {
        e.innerText = msg;
        return false
    }
    e.innerText = "";
    return true
}

function validateDate() {
    let i = document.getElementById("join_date"), e = document.getElementById("dateerr");
    if (!i.value) {
        e.innerText = "Select date";
        return false
    }
    let d = new Date(i.value + "T00:00:00"), t = new Date();
    t.setHours(0, 0, 0, 0);
    if (d > t ) {
        e.innerText = "Future date not allowed";
        return false
    }
    e.innerText = "";
    return true
}

function validateAddress() {
    let i = document.getElementById("address"), e = document.getElementById("adderr");
    if (i.value.trim() === "") {
        e.innerText = "Address required";
        return false
    }
    e.innerText = "";
    return true
}
document.getElementById("staff_name").addEventListener("input", validateName);
document.getElementById("email").addEventListener("input", validateEmail);
document.getElementById("phone").addEventListener("input", validatePhone);
document.getElementById("department").addEventListener("change", () => validateSelect("department", "depterr", "Select department"));
document.getElementById("staffrole").addEventListener("change", () => validateSelect("staffrole", "strerr", "Select staff role"));
document.getElementById("join_date").addEventListener("change", validateDate);
document.getElementById("address").addEventListener("input", validateAddress);
document.querySelectorAll('input[name="Gender"]').forEach(r => r.addEventListener("change", validateGender));
document.getElementById("password").addEventListener("input", validatePassword);
document.getElementById("form").addEventListener("submit", function (e) {

    let v = validateName() & validateEmail() & validatePhone() & validateGender() &
        validateSelect("department", "depterr", "Select department") &
        validateSelect("staffrole", "strerr", "Select staff role") &
        validateDate() & validateAddress()&validatePassword();
    if (!v) e.preventDefault()
});
