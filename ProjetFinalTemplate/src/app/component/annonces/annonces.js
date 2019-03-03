var map= document.querySelector("#map")

var paths=map.querySelectorAll('.map__image a')
var links=map.querySelectorAll('.map__list a')

if(NodeList.prototype.forEach===undefined){
    NodeList.prototype.forEach=function(callback){
        [].forEach.call(this, callback)
    }
}
paths.forEach(function(path){
    path.addEventListener('mouseenter',function(e){
        console.log('Yo');
    })
})