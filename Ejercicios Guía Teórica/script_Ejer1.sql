select * 
	from fabricante;
    
select *
	from producto;
    
select *
	from producto p
    where p.precio > 120 and p.precio < 202;

select *
	from producto 
    where precio > 120 and precio < 202;

select *
	from producto p
    where p.nombre like 'Portátil_%';
    
update producto p
    set p.precio = 150
    where codigo = 12;
    
update producto p
    set p.nombre = 'AS50'
    where codigo = 12;
    
select * 
	from producto p
    where p.nombre = 'AS50';