 PROGRAM ESSAI

      	integer :: i=0
		
		do while (resid .NE. 5.0)
		   resid = abs(x(i))
		   write (*,*) ' Continue execution'
		   i = i+1
		end do

	  
  END PROGRAM