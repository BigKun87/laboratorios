document.querySelectorAll(".acc-btn-orden").forEach(button => {
    button.addEventListener("click", function () {
      const img = this.querySelector("img");
      if (this.classList.contains("collapsed")) {
        img.src = "assets/images/tables/forms/add_box.svg";
      } else {
        img.src = "assets/images/tables/forms/indeterminate.svg";
      }
    });
  });
  