Fichier Fortran 77 pour test de programme d'analyse de code.
Edit� par Pierre Marighetto.
Version 1 (05/02/2013).

-----------------------------------------------------------------------------------------------------------------------

Ce dossier comporte 3 fichiers :

	- README.txt    		Le pr�sent document qui d�crit le contenu du dossier
							et de chacun des fichiers.
	
	- programme_test.f		Un fichier Fortran cod� exclusivement en F77 permettant
							de tester diff�rentes r�gles du RNC ains que les r�gles
							communes.
					
	- no_comment.f			Certaines r�gles de codage sont en rapport avec la pr�sence 
							de commentaire. Afin de v�rifier ces r�gles, no_comment.f est
							un fichier ne comportant aucun commentaire. Une description de
							ce fichier est disponible dans la suite de ce document.
							
-----------------------------------------------------------------------------------------------------------------------

Description de no_comment.f :

- COMMON /PARTAGE/A sert � v�rifier Don.CommonIncl

- FUNCTION EXT() est la fonction utilis�e dans programme_test.f pour v�rifier Tr.TypeFonctionExt

-----------------------------------------------------------------------------------------------------------------------
