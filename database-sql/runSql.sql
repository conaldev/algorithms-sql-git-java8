use QLSV;
update SINHVIEN
set GioiTinh = '1'
where GioiTinh = 'Nam';
update SINHVIEN
set GioiTinh = '2'
where GioiTinh = 'Nu';

select MaSV,
       HoSV,
       TenSV,
       NgaySinh,
       GioiTinh,
       case
           when GioiTinh = 1 then 'nam'
           when GioiTinh = 2 then 'nu'
           end
           as Gender
from SINHVIEN;

select *
from SINHVIEN
         join DMKHOA D on SINHVIEN.MaKH = D.MaKH
where SINHVIEN.HoSV like 'Trần %'
  and D.TenKhoa = 'Anh văn';



update SINHVIEN ifnull
set HocBong = ifnull(HocBong, 0) + 5000
where MaKH in (select MaKH from DMKHOA where TenKhoa = 'Tin Hoc');

update SINHVIEN
set HocBong = ifnull(HocBong, 0) + 5000
where exists(select 1
             from DMKHOA
             where TenKhoa = 'Tin Hoc'
               and DMKHOA.MaKH = SINHVIEN.MaKH);

update KETQUA
set Diem = Diem + 0.5
where Diem < 5
  and MaMH in (select MaMH
               from MONHOC
               where TenMH = 'Cơ sở Dữ liệu');

select right(NgaySinh, 2) as NamSinh
from SINHVIEN
where right(NgaySinh, 2) between 70 and 90;

select TenKhoa, avg(KETQUA.Diem)
from DMKHOA
         join KETQUA;

select DMKHOA.TenKhoa, MONHOC.TenMH, avg(Diem)
from DMKHOA,
     SINHVIEN,
     KETQUA,
     MONHOC
where DMKHOA.MaKH = SINHVIEN.MaKH
  and SINHVIEN.MaSV = KETQUA.MaSV
  and MONHOC.MaMH = KETQUA.MaMH
group by DMKHOA.TenKhoa, MONHOC.TenMH;

with temp as (
    select MaSV
    from KETQUA
    group by MaSV
    order by avg(Diem) desc
    limit 1
)
update SINHVIEN
set HocBong = ifnull(HocBong, 0) + 10000
where MaSV in (select MaSV from temp);


create procedure updateDiem()
begin
    update QLSV.KETQUA
    set Diem=Diem + 1
    where MaSV in (select SINHVIEN.MaSV
                   from SINHVIEN
                            join DMKHOA D on SINHVIEN.MaKH = D.MaKH
                   where TenKhoa = 'Anh văn')
      and Diem < 9;
end;

call updateDiem();
