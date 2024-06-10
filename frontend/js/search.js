 const searchInput = document.getElementById('search')
//Prvo se pise ovo pa u index.html i edit html doodas putanju ka search.js
const params = new URLSearchParams(window.location.search)
const searchParam = params.get('search')

if(searchParam != null && searchParam !=''){
    searchInput.value = searchParam
}

 if(searchParam != null && searchParam != ''){
    
    searchInput.value= searchParam 
 }
 searchInput.addEventListener('keypress', (e)=>{
 if(e.key == 'Enter')doSearch()
 })

 document.getElementById('search-btn')
.addEventListener('click', ()=>{
     doSearch()
})  

function doSearch(){
    if(searchInput.value == '')  return 
    window.location.href=`./index.html?search=${search.value}`
}

function formatDate(iso){
    if(iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS')
}