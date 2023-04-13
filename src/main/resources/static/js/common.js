$.fn.serializeObject = function() {
    var result = null;
    console.log(this);
    try {
        if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if(arr) {
                result = {};
                $.each(arr, function() {
                    result[this.name] = this.value;
                });
            }
        }
    } catch (e) {
        alert(e.message);
    }

    return result;
}