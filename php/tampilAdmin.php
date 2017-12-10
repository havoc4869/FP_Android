<?php 
 
 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
	echo "<pre>";
 
	//Import File Koneksi Database
	require_once('koneksi.php');
	$username="admin";
	$password="admin";
	$query = "select * from admin";
	//Membuat SQL Query
	//Mendapatkan Hasil
	$r = mysqli_query($con,$query);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['id'],
			"password"=>$row['password']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>