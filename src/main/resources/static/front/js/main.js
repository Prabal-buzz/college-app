$(function(){
  $("#year").change(function(){
	 var month=$('#month').val();
    window.location='/calendar?mahina='+month+'&saal='+this.value;

  });
});

$(function(){
  $("#month").change(function(){
	 var year=$('#year').val();
    window.location='/calendar?mahina='+this.value+'&saal='+year;

  });
});


$('.gallery_wrapper').on('mouseenter mouseleave', function(e) {
  
})
 
const toggleTitle=(id)=>{
   $(".title"+id).toggleClass('d-none');
}

const prev_img=(id)=>{
$('#myModal').addClass('d-block');
 document.getElementById("modelimg").src=$('#img'+id).attr('src');
 
var modalimg = document.getElementById("modalimg");
var img = document.getElementById("img"+id);
modalimg.src = img.src;
}

$('.close').click(()=>{
   $('#myModal').removeClass('d-block');  
})
