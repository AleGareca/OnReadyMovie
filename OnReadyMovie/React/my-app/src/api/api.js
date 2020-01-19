import axios from 'axios';

const server = 'http://localhost:7002';

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data)


export const remove = body => request('delete', '/movie', body);
export const addMovie = body => request('post', '/movies/addMovie', body);
