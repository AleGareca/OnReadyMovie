import axios from 'axios';

const server = 'http://localhost:7002';

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data)


export const allMovies = body => request('get', '/movies', body);
export const remove = body => request('delete', '/movies', body);
export const addMovie = body => request('post', '/movies/addMovie', body);
