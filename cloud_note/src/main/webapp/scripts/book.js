function loadUserBooks(){
	//获取userId
	var userId=getCookie("userId");
	//判断是否获取到有效userId
	if(userId==""){
		window.location.href="login.html";
	}
	//发送ajax请求
	$.ajax({
		url:path+"/book/loadbooks.do",
		data:{"userId":userId},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status==0){
				for(var i=0;i<result.data.length;i++){
					//获取笔记本id
					var bookId=result.data[i].cn_notebook_id;
					//获取笔记本名称
					var bookName=result.data[i].cn_notebook_name;
					//创建一个笔记本列表项的li元素
					createBookLi(bookId,bookName);
				}
			}
		/*
			<li class="online"><a class='unchecked'><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i> result.data<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>	
		*/
		},
		error:function(){
			alert("笔记本加载失败");
		}
	});
}


function createBookLi(bookId,bookName){
	var sli="";
		sli+='<li class="online">';
		sli+='<a class="unchecked">';
		sli+='<i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i>';
		sli+=bookName;
		sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button>';	
		sli+="</a>";
		sli+='</li>';
		//将sli元素转换成jQuery对象li元素
		var $li=$(sli);
		//将bookId值与jQuery对象绑定
		$li.data("bookId",bookId);
	$('#book_ul').append($li);
	
}

//加载笔记列表
function loadBookNotes(){
	$('#book_ul').on("click","li",function(){
		//获得bookId
		var bookId=$(this).data("bookId");
		
		$.ajax({
			url:path+"/note/loadnotes.do",
			data:{"bookId":bookId},
			type:"post",
			dataType:"json",
			success:function(result){
				
				if(result.status==0){
					var notes=result.data;
					//清空列表
					$('#note_ul').html("");
					for(var i=0;i<notes.length;i++){
						var noteId=notes[i].cn_note_id;
						var noteTitle=notes[i].cn_note_title;
						createNoteLi(noteId,noteTitle);					
					}
				}
				

			},
			error:function(){
				alert("加载笔记失败！");
			}
		});
	});
}

function createNoteLi(noteId,noteTitle){
	var nli='';
	nli+='<li class="online">';
	nli+='<a>';
	nli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
	nli+='</a>';	
	nli+='<div class="note_menu" tabindex="-1">';
	nli+='<dl>';
	nli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	nli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	nli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'	;
	nli+='</dl>';	
	nli+='</div>';
	nli+='</li>';		
	var $li=$(nli);
	$li.data("noteId",noteId);
	$('#note_ul').append($li);
}

//加载笔记内容
function loadNote(){
	$('#note_ul').on("click","li",function(){
		
		var noteId=$(this).data("noteId");
		$.ajax({
			url:path+"/note/load.do",
			data:{"noteId":noteId},
			type:"post",
			dataType:"json",
			success:function(result){
				//获得笔记标题
				if(result.status==0){
					var noteTitle=result.data.cn_note_title;
					var noteBody=result.data.cn_note_body;
					$('#input_note_title').val(noteTitle);
					um.setContent("");
					um.setContent(noteBody);
				}
			},
			error:function(){
				alert("笔记加载失败！");
			}
		});
	})
}

//保存笔记
function updateNote(){
	$('#save_note').click(function(){
		var $li=$('#note_ul a.checked').parent();
		var noteId=$li.data("noteId");
		var noteTitle=$('#input_note_title').val().trim();
		var noteBody=um.getContent();
		console.log(noteId+','+noteTitle+','+noteBody);
		$.ajax({
			url:path+"/note/update.do",
			data:{"noteId":noteId,"noteTitle":noteTitle,
				"noteBody":noteBody},	
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var str='';
					str+='<a>';
					str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
					str+='</a>';
					$li.empty().append($(str));
					alert(result.msg);
				}
			},
			error:function(){
				alert("更新失败！");
			}
		})
	});
}
//添加笔记本
function addNoteBook(){
	console.log("添加笔记本");
}


//添加笔记
function addNote(){
	$('#can').on("click","#sure_createNote",function(){
		var ok=true;
		var $li=$('#book_ul a.checked').parent();
		var bookId=$li.data("bookId");
		console.log(bookId+"123");
		var noteTitle=$('#input_note').val();
		var userId=getCookie("userId");
		if(bookId==""){
			alert("请选择一个笔记本！")
			ok=false;
		}
		if(noteTitle==""){
			alert("名称不能为空");
			ok=false;
		}
		if(ok){
			$.ajax({
				url:path+"/note/add.do",
				data:{"bookId":bookId,"noteTitle":noteTitle,"userId":userId},
				type:"post",
				dataType:"json",	
				success:function(result){
					if(result.status==0){
						var noteId=result.data;
						createNoteLi(noteId,noteTitle);		
					}
				},
				error:function(){
					alert("创建笔记失败！")
				}	
			});
		}
		
	});
}