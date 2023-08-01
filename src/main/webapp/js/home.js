/**
 * 
 */
window.onload = () => {
    const pictureArea = document.getElementById("picture_in_gallery")

    const images = document.querySelectorAll("#picture_in_gallery img")
    console.log(images)

    let timeElasped = 0;

    const timerId = setInterval( ()=>{
        timeElasped ++
        let visible = timeElasped % 3
        for(let i=0; i<3; i++ ){
            images[i].style.display = "none"
        }
        images[visible].style.display = "block"
   
    }, 3000)



}
