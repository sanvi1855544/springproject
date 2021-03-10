var character = document.getElementById("character");
var block = document.getElementById("block");
var counter=0;
function jump(){
    if(character.classList.contains("animate")){return}
    character.classList.add("animate");
    setTimeout(function(){
        character.classList.remove("animate");
    },300);
}
var paused = false;

block.classList.add("blockanimate");
var checkDead = setInterval(function() {
    if (paused) {
        return;
    }
    let characterTop = parseInt(window.getComputedStyle(character).getPropertyValue("top"));
    let blockLeft = parseInt(window.getComputedStyle(block).getPropertyValue("left"));
    if(blockLeft<20 && blockLeft>-20 && characterTop>=130){

        block.classList.remove("blockanimate");
        block.style.animation = "none";

        paused = true;
        setTimeout(function() {
            console.log("test");
            alert("Game Over. score: "+Math.floor(counter/100));
            counter=0;
            block.style.left = "500px";
            block.classList.add("blockanimate");
            block.style.animation = "";
            paused = false;
        }, 500);


    }else{
        counter++;
        document.getElementById("scoreSpan").innerHTML = Math.floor(counter/100);
    }
}, 10);