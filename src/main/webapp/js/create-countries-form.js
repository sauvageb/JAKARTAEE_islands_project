const countryName = document.getElementById("name");
const img = document.getElementById("pictureOverview");
const regex_HTTP_HTTPS = /[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)?/gi;
const regex = new RegExp(regex_HTTP_HTTPS);
countryName.addEventListener('input', (event) => {
    fetch(`https://www.countryflagsapi.com/png/${countryName.value}`)
        .then(response => response.blob())
        .then(pictureBlob => {
            if (pictureBlob.type == 'image/png') {
                img.src = URL.createObjectURL(pictureBlob);
            } else {
                setPicturePlaceholder();
            }
        });

// let test = document.getElementById("pictureOverview").src;
    if (!img.src.match(regex)) {
        setPicturePlaceholder();
    }
})
;
setPicturePlaceholder();

function setPicturePlaceholder() {
    document.getElementById("pictureOverview").src = 'https://img.icons8.com/ios/500/000000/no-image-gallery.png';
}
