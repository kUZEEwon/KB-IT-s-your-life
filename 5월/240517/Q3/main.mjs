import fs from 'fs';

try {
    const movie = fs.readFileSync('movie.txt');
    const tour = fs.readFileSync('tour.txt');

    console.log('==================');
    console.log(`보고 싶은 영화는 ${movie}이고`);
    console.log(`가고 싶은 여행지는 ${tour}`);
    console.log('==================');
} catch (error) {
    console.error('Error reading files:', error);
}
