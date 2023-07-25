select * 
	from familias;
    
select * 
	from familias
    where num_hijos >= 3 and edad_maxima < 10;

select * 
	from casas;
    
select * 
	from casas
    where fecha_desde >= '2020-08-01' and fecha_hasta <= '2020-08-31' and pais= 'Reino Unido';
    
select *
	from familias f
    where f.email like '%_hotmail_%';