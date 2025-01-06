document.addEventListener("DOMContentLoaded", function () {
    // Select the buttons for the Login and Register tabs
    const loginTab = document.getElementById("loginTab");
    const registerTab = document.getElementById("registerTab");

    // Select the content areas for both tabs
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    // Add event listeners for tab switching
    loginTab.addEventListener("click", function () {
        // Activate Login Tab and Deactivate Register Tab
        loginTab.classList.add("active");
        registerTab.classList.remove("active");

        // Show the Login Form and Hide the Register Form
        loginForm.classList.add("active-tab");
        registerForm.classList.remove("active-tab");
    });

    registerTab.addEventListener("click", function () {
        // Activate Register Tab and Deactivate Login Tab
        registerTab.classList.add("active");
        loginTab.classList.remove("active");

        // Show the Register Form and Hide the Login Form
        registerForm.classList.add("active-tab");
        loginForm.classList.remove("active-tab");
    });
});
