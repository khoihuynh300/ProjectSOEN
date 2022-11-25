<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<link rel="stylesheet" href="<c:url value='/common/notify/notify.css'/>" />
	<div class="toastbox">
      <div id="toast">
        
      </div>
    </div>
	
	<script type="text/javascript">
	function toast({
        title = "",
        message = "",
        type = "info",
        duration = 5000,
      }) {
    	
    	
        const main = document.getElementById("toast");
        if (main) {
        	
          const toast = document.createElement("div");

          const autoTimeout = setTimeout(function(){main.removeChild(toast);},11000)
			
          toast.onclick = function(e){
            
            if (e.target.closest('.toast__close')){
              main.removeChild(toast);
              clearTimeout(autoTimeout);
            }
          }
          const icons = {
            success: "fas fa-check-circle",
            info: "fas fa-info-circle",
            warning: "fas fa-exclamation-circle",
            error: "fas fa-exclamation-circle",
          };
          toast.classList.add("toast", `toast--\${type}`);
          toast.innerHTML = `
          <div class="toast__icon">
            <i class="\${icons[type]}"></i>
          </div>
          <div class="toast__body">
            <h3 class="toast__title">\${title}</h3>
            <p class="toast__msg">\${message}</p>
          </div>
          <div class="toast__close">
            <i class="fa-solid fa-xmark"></i>
          </div>
          `;
          main.appendChild(toast);

          
          

        }

      }
    
    function showtesttoast() {
    	
        toast({
          title: "Success",
          message: "oke",
          type: "success", //or error
        });
    	
      }
</script>