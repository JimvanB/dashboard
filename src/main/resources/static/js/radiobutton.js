$(document).ready(function () {
    $("input[name=radio]").change(function () {
        alert(this.value);
        if (this.value == "A") {
            alert("Yes it A");
        }
        else {
            alert("Yes it E");
        }
    });
});
