function loadStaffs(input) {
    document.getElementById("dateerr").innerHTML = ""
    let date = input.value;
    let d = new Date(date + "T00:00:00");
    let cur_date = new Date();
    cur_date.setHours(0, 0, 0, 0);
    if (d <= cur_date) {
        document.getElementById("dateerr").innerHTML = "please select future date";
        input.focus()
    } else {
        if (!date) return;
        let shift = document.getElementById("shift")
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let staffSelect = document.getElementById("staff");

                staffSelect.innerHTML = '<option value="">--- Select ---</option>';
                let staffs = JSON.parse(this.responseText);

                let selectedStaffId = document.getElementById("selectedStaffId");
                staffs.forEach(staff => {
                    let opt = document.createElement("option");
                    opt.value = staff.id;
                    opt.text = staff.name;
                    staffSelect.appendChild(opt);
                });
                if (selectedStaffId) {
                    staffSelect.value = selectedStaffId.value;
                }
                $('#staff').trigger('change');
            }
        };
        let url = "/get_staffs?date=" + date;
        if (shift) {
            url += "&shift=" + shift.value;
        }
        xhr.open("GET", url, true);
        xhr.send();
    }
}

$(document).ready(function () {
    $('#staff').select2({
        width: '100%'
    });
});
function shifttime() {
    document.getElementById("typerr").innerHTML = ""
    let option = document.getElementById("shift_type")
    let startTime = document.getElementById("start_time")
    let endTime = document.getElementById("end_time")
    if (option.value !== "") {
        if (option.value === "Morning") {
            startTime.value = "08:00"
            endTime.value = "16:00"
        } else if (option.value === "Evening") {
            startTime.value = "16:00"
            endTime.value = "12:00"
        } else if (option.value === "Night") {
            startTime.value = "12:00"
            endTime.value = "08:00"
        }
    } else {
        option.focus();
        document.getElementById("typerr").innerHTML = "select ShiftType"
    }
}

