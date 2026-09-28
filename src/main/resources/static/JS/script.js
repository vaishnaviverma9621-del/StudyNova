const text = [
    "Learn Java",
    "Learn Python",
    "Learn Spring Boot",
    "Prepare for Interviews"
];

let index = 0;
let charIndex = 0;
let currentText = "";
let isDeleting = false;

function typeEffect() {

    currentText = text[index];

    if (!isDeleting) {
        document.getElementById("typing-text").textContent =
            currentText.substring(0, charIndex++);

        if (charIndex > currentText.length) {
            isDeleting = true;
            setTimeout(typeEffect, 1000);
            return;
        }

    } else {

        document.getElementById("typing-text").textContent =
            currentText.substring(0, charIndex--);

        if (charIndex < 0) {
            isDeleting = false;
            index++;

            if (index >= text.length) {
                index = 0;
            }
        }
    }

    setTimeout(typeEffect, 100);
}

typeEffect();





















