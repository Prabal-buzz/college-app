        $('#bar').click(function() {
            $(this).toggleClass('open');
            $('#page-content-wrapper ,#sidebar-wrapper').toggleClass('toggled');

        });
        
        
function changes(id)
{
   
      if($('#active'+id).hasClass('btn-success'))
      {
        $('#active'+id).removeClass('btn-success');
        $('#active'+id).addClass('btn-danger');
        $('#active'+id).html('Passive');
      }
       else
      {
        $('#active'+id).removeClass('btn-danger');
        $('#active'+id).addClass('btn-success');
        $('#active'+id).html('Active');
      }
     
       $.ajax({


        type: 'get',
        url: '/admin/activePassive',
        data: { id: id },
        dataType: "json",
        success: function(response) {

    }
    });
    
    
   
}
function changeCalender(id){
if($('#calender'+id).hasClass('btn-success'))
      {
        $('#calender'+id).removeClass('btn-success');
        $('#calender'+id).addClass('btn-danger');
        $('#calender'+id).html('Disable');
      }
       else
      {
        $('#calender'+id).removeClass('btn-danger');
        $('#calender'+id).addClass('btn-success');
        $('#calender'+id).html('Show');
      }

 $.ajax({


        type: 'get',
        url: '/admin/getAllCalender',
        data: { id: id },
        dataType: "json",
        success: function(response) {
           for(var i=0;i<response.length;i++){
             if(id!=response[i]){
             changeCalenderClass(response[i]);
             }
           }
    }
    });
  $.ajax({


        type: 'get',
        url: '/admin/setCalender',
        data: { id: id },
        dataType: "json",
        success: function(response) {
           
    }
    });
  

}

function changeCalenderClass(id){
 
if($('#calender'+id).hasClass('btn-success')){
     
        $('#calender'+id).removeClass('btn-success');
        $('#calender'+id).addClass('btn-danger');
        $('#calender'+id).html('Disable');
      }

}

// Js for Auto Add Semester fees-content
    $('.amount').keyup(function() {
     var sum = 0;
    $('.amount').each(function() {
        sum += Number($(this).val());
    });
    $('#total').val(sum);
    
    if(sum>10000000)
    {
      $('#form_submit').attr("disabled","true");
    }
    else
    {
        $('#form_submit').removeAttr("disabled","true");
    }
    
    if($('#pacakage__total').val()!=sum)
    {
       $('#form_submit').attr("disabled","true");
    }else
    {
    $('#form_submit').removeAttr("disabled","true");
    }
     
     
});

function changeUserPermission(id){

 if($('#user_'+id).hasClass('btn-success'))
      {
        $('#user_'+id).removeClass('btn-success');
        $('#user_'+id).addClass('btn-danger');
        $('#user_'+id).html('Disable');
      }
       else
      {
        $('#user_'+id).removeClass('btn-danger');
        $('#user_'+id).addClass('btn-success');
        $('#user_'+id).html('Allow');
      }
      
       $.ajax({


        type: 'get',
        url: '/admin/user/changePermission',
        data: { id: id },
        dataType: "json",
        success: function(response) {
           
    }
    });

}
 $(document).ready(function(){
 
   if ($('#full_schoolarship').is(":checked")){
      $('#form_submit').removeAttr("disabled","true");
                     { 
                       
                      makeDisable()
                     }
 }
 
 
 });



// Make Equal To all Semester
    $(document).ready(function(){
        $('#btn1').click(function(){
         
         var x=$('#pacakage__total').val();

        var numX=parseInt(x);

        var allSemFee=Math.floor(numX/8); 
        var remainder=(numX%8);   
         $('#sem1').val(allSemFee);
        $('#sem2').val(allSemFee);
        $('#sem3').val(allSemFee);
        $('#sem4').val(allSemFee);
        $('#sem5').val(allSemFee);
        $('#sem6').val(allSemFee);
        $('#sem7').val(allSemFee);
        $('#sem8').val(allSemFee+remainder);
        var sum = 0;
        $('.amount').each(function() {
        sum += Number($(this).val());
     });
    $('#total').val(sum);
    
     if( $('#pacakage__total').val()==0){
      $('#form_submit').attr("disabled","true");
        }else
        {
         $('#form_submit').removeAttr("disabled","true");
        }
    
    });
    
   
});

    //disble on checking full schoolarship


                $("#full_schoolarship").click(function() { 
                   
                    if ($('#full_schoolarship').is(":checked"))
                     { 
                      $('#form_submit').removeAttr("disabled","true");
                      makeDisable()
                     }
                     else 
                     {
                      $('#form_submit').attr("disabled","true");
                      makeEnable()
                     }
                });
                
                
            function makeDisable(){
                
                  $('#pacakage__total').val(""); 
                        $('#pacakage__total').attr('disabled','true'); 
                         $('#scholarship').attr('disabled','true'); 
                         $('#scholarship').val(""); 
                         $('#sem1').attr('disabled','true'); 
                         $('#sem1').val(""); 
                         $('#sem2').attr('disabled','true'); 
                         $('#sem2').val(""); 
                        $('#sem3').attr('disabled','true'); 
                        $('#sem3').val(""); 
                        $('#sem4').attr('disabled','true'); 
                        $('#sem4').val(""); 
                        $('#sem5').attr('disabled','true'); 
                        $('#sem5').val(""); 
                        $('#sem6').attr('disabled','true'); 
                        $('#sem6').val(""); 
                        $('#sem7').attr('disabled','true'); 
                        $('#sem7').val(""); 
                        $('#sem8').attr('disabled','true');   
                        $('#sem8').val("");   
                        $('#btn1').attr('disabled','true');   
                        $('#btn1').val("");   
            
            }
            
            function makeEnable(){
             $('#pacakage__total').removeAttr('disabled','true');
                       $('#pacakage__total').removeAttr('disabled','true'); 
                         $('#scholarship').removeAttr('disabled','true'); 
                         $('#sem1').removeAttr('disabled','true'); 
                         $('#sem2').removeAttr('disabled','true'); 
                        $('#sem3').removeAttr('disabled','true'); 
                        $('#sem4').removeAttr('disabled','true'); 
                        $('#sem5').removeAttr('disabled','true'); 
                        $('#sem6').removeAttr('disabled','true'); 
                        $('#sem7').removeAttr('disabled','true'); 
                        $('#sem8').removeAttr('disabled','true');   
                        $('#btn1').removeAttr('disabled','true');   
            
            }
            
           
      //File upload hide and show  of fist semesteeer
$(document).ready(function() {
  $("#checkMark1").click(function() {
    $("#form1").toggle("hide");
  });
    $("#checkMark11").click(function() {
    if($('#form1').is(':visible')) {
    $("#form1").toggle("hide");
  }
  });
   $("#checkMark2").click(function() {
    $("#form2").toggle();
  });

});
// check box only selectable in payment of fee

$('input[type="checkbox"]').on('change', function() {
   $('input[type="checkbox"]').not(this).prop('checked', false);
});
//ajax call for smester payment

  const call_sem=(mode,semester,amount,feeId,enteredBy)=>{
         $.ajax({
                      type: 'get',
                      url: `/admin/payment/save/type-cash?mode=${mode}&&semester=${semester}&&amount=${amount}&&feeId=${feeId}&&enteredBy=${enteredBy}`,
                       contentType: false,
                       processData: false,
                      dataType: "json",
                      success: function(res) {
                        sweet_alert("success","Payment has been made successfully");
                        if(semester==1)
                        {
                         $("#amount_first").val("");
                         populate_payment(semester,res);
                        }else if(semester==2){
                        $("#amount_second").val("");
                        populate_payment_second(semester,res);
        
                        }else if(semester==3){
                        $("#amount_third").val("");
                         populate_payment_third(3,res);

                        }else if(semester==4){
                         $("#amount_fourth").val("");
                         populate_payment_fourth(semester,res);
                        }else if(semester==5){
                         $("#amount_fifth").val("");
                         populate_payment_fifth(semester,res);
                        }else if(semester==6){
                         $("#amount_sixth").val("");
                         populate_payment_sixth(semester,res);
                        }else if(semester==7){
                         $("#amount_seventh").val("");
                         populate_payment_seventh(semester,res);
                        }else if(semester==8){
                         $("#amount_eight").val("");
                         populate_payment_eighth(semester,res);
                        }
                        
                      
                    },
                    error:function(err){
                 
                   
                    }
                    
                 });   
  }

// first semester payment

function pay_first(){
  var mode="cash";
  var amountFirst=$('#amount_first').val();
  var fileFirst=$('#file_first').val();
  var enteredBy=$('#entered_by').val();
  var fileFirst=$('#file_first').val();
  var feeId=$('#fee_id').val();

  
   if (!$('#checkMark11').is(":checked") && !$('#checkMark1').is(":checked") || !$('#amount_first').val())
   { 
     sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#checkMark1').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_first').val()){
          
            sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountFirst>parseInt($('#semester_due').text())){
             sweet_alert("error","Excess payment than Due!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_first')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountFirst);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",1);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
         sweet_alert("success","Payment has been made successfully");
         $("#amount_first").val("");
         $("#file_first").val("");
         
         populate_payment(1,res);
        
         }
        });
        
                   
         }  
      }else{  if(amountFirst>parseInt($('#semester_due').text())){
             sweet_alert("error","Excess payment than Due!!");
              exit(0); 
            }  
      
                
               
        	     call_sem(mode,1,amountFirst,feeId,enteredBy)
               
     
          
      }
   
   }
  
  
}

// populate payment  first sem

function  populate_payment(semester,payment){
 var totalDueVal=$('#totaldue_first').text();
 
 var totalVal=$('#totalpaid_first').text();
 if(totalVal==""){totalVal=0;
 }
var newTotal=parseInt(totalVal)+payment.amount;
var newTotalDue=parseInt(totalDueVal);
if((newTotalDue-newTotal)>0){
$('#semester_due').text(newTotalDue-payment.amount);
}else if((newTotalDue-newTotal)<=0){

 $('#payfirst_button').attr('disabled','true'); 
  $('#semester_due').text(0);
  $('#semester_over').text(newTotal-newTotalDue);
   $('#due_sign').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign').addClass('fa fa-check-circle text-success');
}

 
$('#totalpaid_first').text(newTotal);
var data="";
if(payment.mode=='voucher'){
 data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p>  <a class=' pb_custom'><i	class=' btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p>  <a class=' pb_custom'><i	class=' btn btn-success btn-sm'>Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

  
    
  
$("#payment_log1").append(data);

}


// second semester start

     //File upload hide and show  of fist semesteeer
$(document).ready(function() {
  $("#voucher_second").click(function() {
    $("#form2").toggle("hide");
  });
    $("#cash_second").click(function() {
    if($('#form2').is(':visible')) {
    $("#form2").toggle("hide");
  }
  });
 

});

// second semester


function pay_second(){
  var mode="cash";
  var amountSecond=$('#amount_second').val();
  var fileFirst=$('#file_second').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_second').is(":checked") && !$('#voucher_second').is(":checked") || !$('#amount_second').val())
   { 
    sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_second').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_second').val()){
          
             sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountSecond>parseInt($('#totaldue_second').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_second')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountSecond);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",2);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
         sweet_alert("success","Payment has been made successfully");
         $("#amount_second").val("");
         $("#file_second").val("");
         
         populate_payment_second(2,res);
        
         }
        });
             
         }  
      }else{   
               if(amountSecond>parseInt($('#totaldue_second').text())){
               sweet_alert("error","Excess payment than Due");
              exit(0); 
            }
            
               
                  call_sem(mode,2,amountSecond,feeId,enteredBy)
        	
      
     
          
      }
   
   }
  
  
}
	

// populate payment  second sem

function  populate_payment_second(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_second').text();
var semesterDue=$('#semester_due_second').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_second').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_second').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#paysecond_button').attr('disabled','true'); 
  $('#semester_due_second').text(0);
  
   $('#due_sign_second').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_second').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_second").append(data);

}
// third semester start here


     //File upload hide and show  of third semesteeer
$(document).ready(function() {
  $("#voucher_third").click(function() {
    $("#form3").toggle("hide");
  });
    $("#cash_third").click(function() {
    if($('#form3').is(':visible')) {
    $("#form3").toggle("hide");
   }
  });
 });

function pay_third(){
  var mode="cash";
  var amountThird=$('#amount_third').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_third').is(":checked") && !$('#voucher_third').is(":checked") || !$('#amount_third').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_third').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_third').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountThird>parseInt($('#totaldue_third').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_third')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountThird);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",3);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_third").val("");
         $("#file_third").val("");
         
         populate_payment_third(3,res);
        
         }
        });
             
         }  
      }else{   
               if(amountThird>parseInt($('#totaldue_third').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
                    	call_sem(mode,3,amountThird,feeId,enteredBy)
            
      }
   
   }
  
  
}
	

// populate payment  third sem

function  populate_payment_third(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_third').text();
var semesterDue=$('#semester_due_third').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_third').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_third').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#paythird_button').attr('disabled','true'); 
  $('#semester_due_third').text(0);
  
   $('#due_sign_third').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_third').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_third").append(data);

}

// Fourth semester start here
 //File upload hide and show  of fourth semesteeer
$(document).ready(function() {
  $("#voucher_fourth").click(function() {
    $("#form4").toggle("hide");
  });
    $("#cash_fourth").click(function() {
    if($('#form4').is(':visible')) {
    $("#form4").toggle("hide");
   }
  });
 });

function pay_fourth(){
  var mode="cash";
  var amountFourth=$('#amount_fourth').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_fourth').is(":checked") && !$('#voucher_fourth').is(":checked") || !$('#amount_fourth').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_fourth').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_fourth').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountFourth>parseInt($('#totaldue_fourth').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_fourth')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountFourth);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",4);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_fourth").val("");
         $("#file_fourth").val("");
         
         populate_payment_fourth(4,res);
        
         }
        });
             
         }  
      }else{   
               if(amountFourth>parseInt($('#totaldue_fourth').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
               call_sem(mode,4,amountFourth,feeId,enteredBy)
        	
      
     
          
      }
   
   }
  
  
}
	

// populate payment  fourth  sem

function  populate_payment_fourth(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_fourth').text();
var semesterDue=$('#semester_due_fourth').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_fourth').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_fourth').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#payfourth_button').attr('disabled','true'); 
  $('#semester_due_fourth').text(0);
  
   $('#due_sign_fourth').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_fourth').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_fourth").append(data);

}
// fifth semester start here

 //File upload hide and show  of fifth semesteeer
$(document).ready(function() {
  $("#voucher_fifth").click(function() {
    $("#form5").toggle("hide");
  });
    $("#cash_fifth").click(function() {
    if($('#form5').is(':visible')) {
    $("#form5").toggle("hide");
   }
  });
 });

function pay_fifth(){
  var mode="cash";
  var amountFifth=$('#amount_fifth').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_fifth').is(":checked") && !$('#voucher_fifth').is(":checked") || !$('#amount_fifth').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_fifth').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_fifth').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountFifth>parseInt($('#totaldue_fifth').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_fifth')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountFifth);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",5);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_fifth").val("");
         $("#file_fifth").val("");
         
         populate_payment_fifth(5,res);
        
         }
        });
             
         }  
      }else{   
               if(amountFifth>parseInt($('#totaldue_fifth').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
                    call_sem(mode,5,amountFifth,feeId,enteredBy)
        }
   
   }
 }
	

// populate payment  fifth  sem

function  populate_payment_fifth(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_fifth').text();
var semesterDue=$('#semester_due_fifth').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_fifth').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_fifth').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#payfifth_button').attr('disabled','true'); 
  $('#semester_due_fifth').text(0);
  
   $('#due_sign_fifth').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_fifth').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_fifth").append(data);

} 

// sixtt semester start here

 //File upload hide and show  of sixth semesteeer
$(document).ready(function() {
  $("#voucher_sixth").click(function() {
    $("#form6").toggle("hide");
  });
    $("#cash_sixth").click(function() {
    if($('#form6').is(':visible')) {
    $("#form6").toggle("hide");
   }
  });
 });

function pay_sixth(){
  var mode="cash";
  var amountSixth=$('#amount_sixth').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_sixth').is(":checked") && !$('#voucher_sixth').is(":checked") || !$('#amount_sixth').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_sixth').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_sixth').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountSixth>parseInt($('#totaldue_sixth').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_sixth')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountSixth);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",6);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_sixth").val("");
         $("#file_sixth").val("");
         
         populate_payment_sixth(6,res);
        
         }
        });
             
         }  
      }else{   
               if(amountSixth>parseInt($('#totaldue_sixth').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
                call_sem(mode,6,amountSixth,feeId,enteredBy)
        }
   
   }
 }
	

// populate payment  sixth  sem

function  populate_payment_sixth(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_sixth').text();
var semesterDue=$('#semester_due_sixth').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_sixth').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_sixth').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#paysixth_button').attr('disabled','true'); 
  $('#semester_due_sixth').text(0);
  
   $('#due_sign_sixth').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_sixth').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_sixth").append(data);

}
// sevent semester start here

 //File upload hide and show  of sixth semesteeer
$(document).ready(function() {
  $("#voucher_seventh").click(function() {
    $("#form7").toggle("hide");
  });
    $("#cash_seventh").click(function() {
    if($('#form7').is(':visible')) {
    $("#form7").toggle("hide");
   }
  });
 });

function pay_seventh(){
  var mode="cash";
  var amountSeventh=$('#amount_seventh').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_seventh').is(":checked") && !$('#voucher_seventh').is(":checked") || !$('#amount_seventh').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_seventh').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_seventh').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountSeventh>parseInt($('#totaldue_seventh').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_seventh')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountSeventh);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",7);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_seventh").val("");
         $("#file_seventh").val("");
         
         populate_payment_seventh(7,res);
        
         }
        });
             
         }  
      }else{   
               if(amountSeventh>parseInt($('#totaldue_seventh').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
                  call_sem(mode,7,amountSeventh,feeId,enteredBy)
        }
   
   }
 }
	

// populate payment  sixth  sem

function  populate_payment_seventh(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_seventh').text();
var semesterDue=$('#semester_due_seventh').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);
 $('#totalpaid_seventh').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_seventh').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#payseventh_button').attr('disabled','true'); 
  $('#semester_due_seventh').text(0);
  
   $('#due_sign_seventh').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_seventh').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_seventh").append(data);

}
// eighth semester start here

 //File upload hide and show  of eighth semesteeer
$(document).ready(function() {
  $("#voucher_eighth").click(function() {
    $("#form8").toggle("hide");
  });
    $("#cash_eighth").click(function() {
    if($('#form8').is(':visible')) {
    $("#form8").toggle("hide");
   }
  });
 });

function pay_eighth(){
  var mode="cash";
  var amountEighth=$('#amount_eighth').val();
  var enteredBy=$('#entered_by').val();
  var feeId=$('#fee_id').val();
 
  
   if (!$('#cash_eighth').is(":checked") && !$('#voucher_eighth').is(":checked") || !$('#amount_eighth').val())
   { sweet_alert("error","Make sure you have checked mode and insert amount!!!");
   }
   else
   {
      if($('#voucher_eighth').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_eighth').val()){
          
           sweet_alert("error","Insert File !!!");
           }
         else{
          
            if(amountEighth>parseInt($('#totaldue_eighth').text())){
              sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
            
        var fd = new FormData();
        var files = $('#file_eighth')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amount",amountEighth);
        fd.append("feeId",feeId);
        fd.append("enteredBy",enteredBy);
          fd.append("semester",8);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(res) {
           sweet_alert("success","Payment has been made successfully");
         $("#amount_eighth").val("");
         $("#file_eighth").val("");
         
         populate_payment_eighth(8,res);
        
         }
        });
             
         }  
      }else{   
               if(amountEighth>parseInt($('#totaldue_eighth').text())){
             sweet_alert("error","Excess payment than Due!!!");
              exit(0); 
            }
            
               call_sem(mode,8,amountEighth,feeId,enteredBy)
        }
   
   }
 }
	

// populate payment  eighth  sem

function  populate_payment_eighth(semester,payment){
var totalPaid;
totalPaid=$('#totalpaid_eighth').text();
var semesterDue=$('#semester_due_eighth').text();
if(totalPaid==""){totalPaid=0;
 }
var newTotalPaid=parseInt(totalPaid)+payment.amount;
var newSemesterDue=parseInt(semesterDue);

 $('#totalpaid_eighth').text(newTotalPaid);
if((newSemesterDue-newTotalPaid)>0){
$('#semester_due_eighth').text(newSemesterDue-payment.amount);
}else if((newSemesterDue-newTotalPaid)<=0){

 $('#payeighth_button').attr('disabled','true'); 
  $('#semester_due_eighth').text(0);
  
   $('#due_sign_eighth').removeClass('fas fa-exclamation-triangle text-danger');
        $('#due_sign_eighth').addClass('fa fa-check-circle text-success');
}

 
var data="";
if(payment.mode=='cash'){
 data=" <div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p><a  class='pb_custom'><i class=' btn btn-success btn-sm mr-3'> Cash</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}else{
data="<div class='log__dates1 mb-2'>"+
    "<p>"+payment.createdAt+"</p>"+
    "<p> <a class='pb_custom'><i class='btn btn-success btn-sm'>Voucher</i></a></p>"+
    "<p>"+payment.amount+" </p>"+
    "</div>";
}

$("#payment_log_eighth").append(data);

}

function sweet_alert(icon,title){
 Swal.fire({
  position: 'top-end',
  icon: icon,
  title: title,
  showConfirmButton: false,
  timer: 3000
})
}

//calender part
let change_days=(day,id,type)=>{
  
    $('#no__day'+id).val(day);
}





$(document).ready(function() {
  $(window).keydown(function(event){
    if(event.keyCode == 13) {
      event.preventDefault();
      return false;
    }
  });
});



const calculate_days=(id,type)=>{
if(type===1){
let start;
 let end;
 start=$('#starting__day'+id).val();
 end=$('#ending__day1'+id).val();
change_days(Math.abs(end-start)+1,id,type)

}else{
let start;
 let end;
  let start1;
 let end1;
 start=$('#starting__day'+id).val();
 end=$('#ending__day'+id).val();
 
 start1=$('#starting__day'+id+'2').val();
 end1=$('#ending__day'+id+'2').val();
change_days((Math.abs(end-start)+1)+(Math.abs(end1-start1)+1),id,type)
}
 
 
 }
 
 $('#selected_month').change(()=>{
   
   const id=$('#selected_month').val();
   
    fetch("/admin/event/getmonth/"+id)
   .then(response => response.json())
   .then (function(repos){
   fillMonth(repos);
   })
   
 })
 
 const fillMonth=(result)=>{
 $('#day_from_selected_month').text("");
 let i;
 let final=``;
 for(i=0;i<result;i++){
   final=final+`
    <option value="${i+1}">${i+1}</option>  
    `;
 }
 $('#day_from_selected_month').append(final);
 
 
 }
 
 
 // for event 
 $('#selected__month').change(()=>{
 const id=$('#selected__month').val()
 
 /*  fetch("/admin/event/month/"+id)
   .then(response => response.json())
   .then (function(repos){
    populate_calendar_event(repos);
   })
  */
 
 })

const populate_calendar_event=(result)=>{
console.log(result)
/* $('#calendar_event_data').append(final_result);*/
}

 const goBack=()=>{
  window.history.back();
 }

