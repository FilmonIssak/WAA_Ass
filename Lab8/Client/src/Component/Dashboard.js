import React, { useEffect, useState } from 'react'
import Posts from '../Component/Posts';
import PostDetail from './PostDetail';
import axios from 'axios';
import AddPost from './AddPost';


export default function Dashboard() {

    const [postsState, setPostsState] = useState([]);
    const [postDetail, setPostDetail] = useState({})
    const [title, setTitle] = useState('')

    useEffect(() => {
        fetchData()
    }, [])

    //get all post
    const fetchData = () => {
        axios.get('http://localhost:8081/api/v1/posts')
            .then((res) => {
                setPostsState(res.data)
            }).catch(err => {
                console.log(err.message);
            })
    }

    // get post by id 

    const getPostById = (id) => {
        axios.get(`http://localhost:8081/api/v1/posts/${id}`).then((res) => {
            setPostDetail(res.data)
        })

    }

    // add post
    const addNewPost = (title, author, content) => {
        axios.post('http://localhost:8081/api/v1/posts', { title: title, author: author, content: content }).then((res) => {
            fetchData()
        })

    };

    //delete post
    const deletePost = (id) => {
        axios.delete(`http://localhost:8081/api/v1/posts/${id}`)
            .then(res => {
                if (res) {
                    alert("Post has been deleted sucessfully!!")
                }
            })
        const arrayAfterDelete = postsState.filter((data) => data.id !== id)
        setPostsState(arrayAfterDelete)
    };

    const handleInput = () => {
        const copy = [...postsState];
        copy[0].title = title
        setPostsState(copy)
    }

    return (
        <div >
            <div style={{ display: "inline-flex" }}>
                <Posts data={postsState} getPostById={getPostById} />
            </div>
            <br>
            </br>
            <div>
                <input onChange={(event) => setTitle(event.target.value)} type='text' />
                <button onClick={handleInput}>Change Title</button>
            </div>


            <div>
                <PostDetail data={postDetail} deletePost={deletePost} />
            </div>

            <div>
                <AddPost addNewPost={addNewPost} />
            </div>

        </div>
    )
}

