$(document).ready(() =>{
    $('.delete-bt').on('click', function () {
        const id = $(this).attr('data-id');

        if(confirm("Are you sure you want to delete post?")){
            document.location.replace('/posts/delete/' + id);
        }

    });
});

$(document).ready(() =>{
    $('.edit-bt').on('click', function () {
        const id = $(this).attr('data-id');
        if(confirm("Are you sure you want to edit post?")){
            document.location.replace('/posts/edit/' + id);
        }
    });
});
